package com.example.vegan_life.service;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberResponse registerMember(MemberRequest dto) {
        String encoded = passwordEncoder.encode(dto.getPassword());
        // 중복 확인 추가

        dto.setPassword(encoded);

        Member saved = dto.toEntity();
        memberRepository.save(saved);

        return MemberResponse.of(saved);
    }

    public boolean login(String email, String rawPassword) {
        Member target = memberRepository.findByEmail(email).orElseThrow(HttpClientErrorException.Unauthorized::new);

        String encodedPassword = passwordEncoder.encode(rawPassword);
        if (encodedPassword.equals(target.getPassword())) {
            return true;
        }
        return false;

    }
}