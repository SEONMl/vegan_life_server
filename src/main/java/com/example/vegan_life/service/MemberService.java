package com.example.vegan_life.service;

import com.example.vegan_life.dto.MemberDto;
import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MemberEntity getMemberInfo(MemberDto dto) {
        MemberEntity target = memberRepository.findById(dto.getMember_id()).orElse(null);
        return target;
    }

    @Transactional
    public MemberEntity modifyMemberInfo(MemberDto dto) {
        MemberEntity target =memberRepository.findById(dto.getMember_id()).orElse(null);
        if (target != null){
            target.update(dto);
        }
        return target;
    }
}
