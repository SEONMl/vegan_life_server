package com.example.vegan_life.service;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentDto;
import com.example.vegan_life.entity.ArticleEntity;
import com.example.vegan_life.entity.CommentEntity;
import com.example.vegan_life.entity.MemberEntity;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.CommentRepository;
import com.example.vegan_life.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CommentRepository commentRepository;

    public ArticleEntity createArticle(ArticleDto dto) {
        MemberEntity target = memberRepository.findByEmail(dto.getWriter()).orElse(null);
        ArticleEntity saved = ArticleEntity.builder()
                .content(dto.getContent())
                .community_code(dto.getCommunity_code())
                .member_id(target)
                .build();
        articleRepository.save(saved);
        return saved;
    }

    public List<ArticleEntity> getAllArticles() {
        List<ArticleEntity> targets = articleRepository.findAll();
        return targets;
    }

    public CommentEntity createComment(Long article_id, CommentDto dto) {
        ArticleEntity parentArticle = articleRepository.findById(article_id).orElse(null);
        MemberEntity writer = memberRepository.findById(dto.getMember_id()).orElse(null);
        CommentEntity saved = CommentEntity.builder()
                .content(dto.getContent())
                .member_id(writer)
                .article_id(parentArticle)
                .build();
        commentRepository.save(saved);
        return saved;
    }

    public ArticleEntity getArticle(Long article_id) {
        return articleRepository.findById(article_id).orElse(null);
    }
}
