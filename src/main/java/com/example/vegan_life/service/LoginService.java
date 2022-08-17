package com.example.vegan_life.service;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponse registerMember(MemberRequest dto) {
        Member member = memberRepository.findByEmail(dto.getEmail()).orElse(null);
        if (member!=null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"이미 존재하는 회원입니다.");
        }
        String encoded = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encoded);

        Member saved = dto.toEntity();
        memberRepository.save(saved);

        return MemberResponse.of(saved);
    }

    public Void login(String email, String rawPassword) {
        Member target = memberRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);

        if (passwordEncoder.matches(rawPassword,target.getPassword())) {
            return null;
        }
        else{
            throw new UsernameNotFoundException("비밀번호가 옳지 않습니다.");
        }

    }
}