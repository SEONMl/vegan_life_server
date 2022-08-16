package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<MemberResponse> getMemberInfo(@RequestBody MemberRequest dto){
        MemberResponse result = memberService.getMemberInfo(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

//    @PatchMapping("/members")
//    public ResponseEntity<MemberResponse> modifyPassword(@RequestBody MemberRequest dto){
//        Member result = memberService.modifyMemberInfo(dto);
//        if (result == null) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
//        else return ResponseEntity.status(HttpStatus.OK).body(result);
//    }


}
