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

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;


    @PostMapping("/api/sign-up")
    public ResponseEntity register(@RequestBody MemberDto dto){
        MemberEntity result = loginService.registerMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
