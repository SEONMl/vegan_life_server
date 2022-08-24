package com.example.vegan_life.controller;

import com.example.vegan_life.dto.CreateMemberRequestDto;
import com.example.vegan_life.dto.CreateMemberResponseDto;
import com.example.vegan_life.dto.ModifyPasswordDto;
import com.example.vegan_life.dto.MyPageResponseDto;
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
    public ResponseEntity<CreateMemberResponseDto> getMemberInfo(@RequestBody CreateMemberRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PatchMapping("/member/password")
    public ResponseEntity<CreateMemberResponseDto> modifyPassword(@RequestBody ModifyPasswordDto dto) {
        CreateMemberResponseDto result = memberService.modifyPassword(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } // TODO responseDto로 변경

    @GetMapping("/member/mypage")
    public ResponseEntity<MyPageResponseDto> getMypage() {
        MyPageResponseDto result = memberService.getMypage();
        return ResponseEntity.ok(result);
    }
}
