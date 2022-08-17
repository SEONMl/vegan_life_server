package com.example.vegan_life.service;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.dto.ModifyPasswordDto;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;


    @Transactional
    public MemberResponse modifyPassword(Long id, ModifyPasswordDto dto) {
        Member target = memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if (passwordEncoder.matches(dto.getPassword(),target.getPassword())){
            String newEncodedPassword = passwordEncoder.encode(dto.getNewPassword());
            target.setPassword(newEncodedPassword);
            return MemberResponse.of(target);
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"비밀번호가 옳지 않습니다.");
        }
    }
}
