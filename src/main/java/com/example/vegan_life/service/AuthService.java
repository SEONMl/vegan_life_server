package com.example.vegan_life.service;

import com.example.vegan_life.dto.CreateMemberRequestDto;
import com.example.vegan_life.dto.CreateMemberResponseDto;
import com.example.vegan_life.dto.LoginRequestDto;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.MemberRepository;
import com.example.vegan_life.repository.RefreshTokenRepository;
import com.example.vegan_life.security.auth.RefreshToken;
import com.example.vegan_life.security.auth.TokenDto;
import com.example.vegan_life.security.auth.TokenProvider;
import com.example.vegan_life.security.auth.TokenRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    public CreateMemberResponseDto registerMember(CreateMemberRequestDto dto) {
        Member member = memberRepository.findByEmail(dto.getEmail()).orElse(null);
        if (member!=null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "이미 존재하는 회원입니다.");
        }
        String encoded = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encoded);

        Member entity = dto.toEntity();
        entity.setCreatedAt();
        memberRepository.save(entity);

        return CreateMemberResponseDto.of(entity);
    }

    public TokenDto login(LoginRequestDto dto) {
        // 1. ID/PW 기반으로 AuthenticatoinToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = dto.toAuthentication();

        // 2. 실제로 검증이 이루어지는 부분 (사용자 비밀번호 체크)
        Member target = memberRepository.findByEmail(dto.getEmail()).orElseThrow(EntityNotFoundException::new);

        if (! passwordEncoder.matches(dto.getPassword(),target.getPassword())) {
            throw new UsernameNotFoundException("비밀번호가 옳지 않습니다.");
        }
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 Jwt 토큰 생성
        TokenDto tokenDto = tokenProvider.createToken(authentication);

        // 4. RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .key(authentication.getName())
                .value(tokenDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        return tokenDto;

    }

    public TokenDto reissue(TokenRequestDto tokenRequestDto) {
        // 1. Refresh Token 검증
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())){
            throw new RuntimeException("Refresh Token이 유효하지 않습니다.");
        }

        // 2. Access Token에서 Member id 가져오기
        Authentication authentication= tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // 3. Repository에서 Member Id 기반으로 Refresh Token 값을 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(RuntimeException::new);

        // 4. Refresh Token 일치하는지 검사
        if (!refreshToken.getValue().equals(tokenRequestDto.getRefreshToken())){
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 5. 새로운 토큰 생성
        TokenDto tokenDto = tokenProvider.createToken(authentication);

        // 6. 저장소 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDto.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        return tokenDto;
    }
}