package com.example.vegan_life.service;

import com.example.vegan_life.dto.MemberDto;
import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Autowired
    MemberRepository memberRepository;
    PasswordEncoder passwordEncoder;

    public MemberEntity registerMember(MemberDto dto) {
        String encodedPW = passwordEncoder.encode(dto.getPassword());

        MemberEntity saved = MemberEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .height(dto.getHeight())
                .weight(dto.getWeight())
                .password(encodedPW)
                .vege_type(dto.getVege_type())
                .build();
        memberRepository.save(saved);

        return saved;
    }

    public void checkAccount(String email, String password) {

    }
}
