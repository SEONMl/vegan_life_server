package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberRequestDto;
import com.example.vegan_life.dto.MemberResponseDto;
import com.example.vegan_life.dto.ModifyPasswordDto;
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
    public ResponseEntity<MemberResponseDto> getMemberInfo(@RequestBody MemberRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PatchMapping("/member/{id}/password")
    public ResponseEntity<MemberResponseDto> modifyPassword(@PathVariable Long id,
                                                            @RequestBody ModifyPasswordDto dto){
        MemberResponseDto result = memberService.modifyPassword(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
