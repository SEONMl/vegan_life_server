package com.example.vegan_life.controller;

import com.example.vegan_life.dto.CreateMemberRequestDto;
import com.example.vegan_life.dto.CreateMemberResponseDto;
import com.example.vegan_life.dto.LoginRequestDto;
import com.example.vegan_life.security.auth.TokenDto;
import com.example.vegan_life.security.auth.TokenRequestDto;
import com.example.vegan_life.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping()
    public String hello(){
        return "hello";
    }


    @PostMapping("/join")
    public ResponseEntity<CreateMemberResponseDto> register(@RequestBody CreateMemberRequestDto dto) {
        CreateMemberResponseDto result = authService.registerMember(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequestDto dto,
                                      HttpServletResponse response) {
        TokenDto tokenDto = authService.login(dto);
        response = setTokenInCookie(tokenDto, response);
        return ResponseEntity.status(HttpStatus.OK).body(tokenDto);
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto,
                                            HttpServletResponse response){
        TokenDto tokenDto = authService.reissue(tokenRequestDto);
        response = setTokenInCookie(tokenDto, response);
        return ResponseEntity.ok(tokenDto);
    }

    private HttpServletResponse setTokenInCookie(TokenDto tokenDto, HttpServletResponse response) {
        Cookie accessTokenCookie = new Cookie("access_token", tokenDto.getAccessToken());
        accessTokenCookie.setPath("/");
        Cookie refreshTokenCookie = new Cookie("refresh_token", tokenDto.getRefreshToken());
        refreshTokenCookie.setPath("/");
        response.addCookie(accessTokenCookie);
        response.addCookie(refreshTokenCookie);
        return response;
    }

}
