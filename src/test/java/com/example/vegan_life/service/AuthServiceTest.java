package com.example.vegan_life.service;

import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class AuthServiceTest {
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
        Member entity=memberRepository.findByEmail("aaa").orElse(null);

        assertAll(
                ()-> assertTrue(passwordEncoder.matches(rawPassword, entity.getPassword()))
        );
    }
}