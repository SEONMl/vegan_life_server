package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @PostMapping("/join")
    public ResponseEntity<MemberResponse> register(@RequestBody MemberRequest dto) {
        MemberResponse result = loginService.registerMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponse> login(@RequestBody Map<String, String> json) {
        boolean result = loginService.login(json.get("email"), json.get("password"));
        if (result)
            return ResponseEntity.status(HttpStatus.OK).body("");
    }


}
