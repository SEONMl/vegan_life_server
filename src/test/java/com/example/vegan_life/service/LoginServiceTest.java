package com.example.vegan_life.service;

import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    void checkAccountTest() {

    }

    @Test
    void passwordTest(){
        String rawPassword = "aaa";
        MemberEntity entity=memberRepository.findByEmail("aaa").orElse(null);

        assertAll(
                ()-> assertTrue(passwordEncoder.matches(rawPassword, entity.getPassword()))
        );
    }
}