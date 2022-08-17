package com.example.vegan_life.controller;

import com.example.vegan_life.dto.MemberRequest;
import com.example.vegan_life.dto.MemberResponse;
import com.example.vegan_life.security.TokenProvider;
import com.example.vegan_life.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity<Void> login(@RequestBody Map<String, String> json,
                                      HttpServletResponse response) {
        String email = json.get("email");
        String password = json.get("password");
        loginService.login(email, password);

        String accessToken = TokenProvider.createToken(email, (2*1000*60));
        Cookie cookie = new Cookie(email, accessToken);
        cookie.setPath("/");
        response.addCookie(cookie);

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
