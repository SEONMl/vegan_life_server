package com.example.vegan_life.service;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse getMemberInfo(MemberRequest dto) {
        Member target = memberRepository.findById(dto.getMember_id()).orElseThrow(EntityNotFoundException::new);
        MemberResponse response = MemberResponse.of(target);
        return response;
    }

    @Transactional
    public Member modifyMemberInfo(MemberRequest dto) {
        Member target =memberRepository.findById(dto.getMember_id()).orElse(null);
        if (target != null){
            target.update(dto);
        }
        return target;
    }
}
