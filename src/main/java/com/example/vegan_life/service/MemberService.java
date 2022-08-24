package com.example.vegan_life.service;

import com.example.vegan_life.dto.CreateMemberResponseDto;
import com.example.vegan_life.dto.ModifyPasswordDto;
import com.example.vegan_life.dto.MyPageResponseDto;
import com.example.vegan_life.dto.RecipeLikeDto;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.entity.RecipeLike;
import com.example.vegan_life.repository.MemberRepository;
import com.example.vegan_life.repository.RecipeLikeRepository;
import com.example.vegan_life.security.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final RecipeLikeRepository recipeLikeRepository;

    private final PasswordEncoder passwordEncoder;


    @Transactional
    public CreateMemberResponseDto modifyPassword(ModifyPasswordDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Member target = memberRepository.findByEmail(curUser).orElseThrow(EntityNotFoundException::new);
        if (passwordEncoder.matches(dto.getPassword(),target.getPassword())){
            String newEncodedPassword = passwordEncoder.encode(dto.getNewPassword());
            target.setPassword(newEncodedPassword);
            target.setUpdatedAt();
            return CreateMemberResponseDto.of(target);
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 옳지 않습니다.");
        }
    }

    public MyPageResponseDto getMypage() {
        String curUser = CustomUserDetailsService.getCurUser();
        Member member = memberRepository.findByEmail(curUser).orElseThrow(EntityNotFoundException::new);
        // 찜한 레시피 표시
        return MyPageResponseDto.of(member);
    }
}
