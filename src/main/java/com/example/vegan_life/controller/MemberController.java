package com.example.vegan_life.controller;

import com.example.vegan_life.dto.CreateMemberRequestDto;
import com.example.vegan_life.dto.CreateMemberResponseDto;
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
    public ResponseEntity<CreateMemberResponseDto> getMemberInfo(@RequestBody CreateMemberRequestDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PatchMapping("/member/{id}/password")
    public ResponseEntity<CreateMemberResponseDto> modifyPassword(@PathVariable Long id,
                                                                  @RequestBody ModifyPasswordDto dto){
        CreateMemberResponseDto result = memberService.modifyPassword(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    } // TODO responseDto로 변경


}
