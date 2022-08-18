package com.example.vegan_life.service;

import com.example.vegan_life.dto.ArticleLikeDto;
import com.example.vegan_life.repository.ArticleLikeRepository;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.CommentRepository;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleLikeService {
    private final ArticleLikeRepository articleLikeRepo;
    private final MemberRepository memberRepo;
    private final ArticleRepository articleRepo;
    private final CommentRepository commentRepo;

    public ArticleLikeDto like(ArticleLikeDto dto) {

        return dto;
    }

    public ArticleLikeDto unLike(ArticleLikeDto dto) {
        return dto;
    }
}
