package com.example.vegan_life.service;

import com.example.vegan_life.entity.ArticleEntity;
import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class LoginServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ArticleRepository articleRepository;


    @Test
    void checkAccountTest() {
        Optional<MemberEntity> target= memberRepository.findById(1l);
        MemberEntity memberEntity=memberRepository.findByEmail("123");
        List<MemberEntity> t=memberRepository.findAll();
        System.out.println(target);
        System.out.println(memberEntity);
        t.stream().forEach(s->{
            System.out.println(s.getEmail()+", "+s.getPassword());
        });
    }

    @Test
    void t(){
        ArticleEntity ar=ArticleEntity.builder()
                .community_code(0)
                .content("test")
                .build();
        articleRepository.save(ar);
        List<ArticleEntity> ta=articleRepository.findAll();
        System.out.println(ta.get(0).getContent());
    }
}