package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberDto;
import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/join")
    public ResponseEntity register(@RequestBody MemberDto dto) {
        MemberEntity result = loginService.registerMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> json) {
        boolean result = loginService.login(json.get("email"), json.get("password"));
        if (result)
            return ResponseEntity.status(HttpStatus.OK).body("");
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("");
    }


}
