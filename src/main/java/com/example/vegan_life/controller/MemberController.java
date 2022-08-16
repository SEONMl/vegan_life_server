package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberDto;
import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity getMemberInfo(@RequestBody MemberDto dto){
        MemberEntity result = memberService.getMemberInfo(dto);
        if (result == null) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/members")
    public ResponseEntity modifyMemberInfo(@RequestBody MemberDto dto){
        MemberEntity result = memberService.modifyMemberInfo(dto);
        if (result == null) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
