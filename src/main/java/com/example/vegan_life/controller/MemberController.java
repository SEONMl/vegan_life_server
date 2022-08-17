package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.dto.ModifyPasswordDto;
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
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PatchMapping("/member/{id}/password")
    public ResponseEntity<MemberResponse> modifyPassword(@PathVariable Long id,
                                                         @RequestBody ModifyPasswordDto dto){
        MemberResponse result = memberService.modifyPassword(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
