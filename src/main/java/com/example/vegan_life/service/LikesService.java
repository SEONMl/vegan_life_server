package com.example.vegan_life.service;

import com.example.vegan_life.dto.ArticleLikeDto;
import com.example.vegan_life.dto.CommentLikeDto;
import com.example.vegan_life.dto.RecipeLikeDto;
import com.example.vegan_life.entity.*;
import com.example.vegan_life.repository.*;
import com.example.vegan_life.security.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikesService {
    private final ArticleLikeRepository articleLikeRepo;
    private final CommentLikeRepository commentLikeRepo;
    private final RecipeLikeRepository recipeLikeRepo;
    private final ArticleRepository articleRepo;
    private final CommentRepository commentRepo;
    private final RecipeRepository recipeRepo;
    private final MemberRepository memberRepo;

    @Transactional
    public ArticleLikeDto articleLike(ArticleLikeDto dto) {
        Article article = articleRepo.findById(dto.getArticleId()).orElseThrow(EntityNotFoundException::new);

        if (dto.getLike()){
            ArticleLike entity = articleLikeRepo.findByArticleId(dto.getArticleId()).orElse(new ArticleLike(article,0));
            articleLikeRepo.save(entity);
            entity.like();
        }
        return dto;
    }

    public ArticleLikeDto articleUnLike(ArticleLikeDto dto) {
        return dto;
    }

    @Transactional
    public CommentLikeDto commentLike(CommentLikeDto dto) {
        Comments comments = commentRepo.findById(dto.getCommentId()).orElseThrow(EntityNotFoundException::new);

        if (dto.getLike()){
            CommentLike entity = commentLikeRepo.findByCommentId(dto.getCommentId()).orElse(new CommentLike(comments,0));
            commentLikeRepo.save(entity);
            entity.like();
        }
        return dto;
    }

    public RecipeLikeDto recipeLike(RecipeLikeDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Member member = memberRepo.findByEmail(curUser).orElseThrow(EntityNotFoundException::new);
        Recipe recipe = recipeRepo.findById(dto.getRecipeId()).orElseThrow(EntityNotFoundException::new);
        RecipeLike entity = RecipeLike.builder()
                .member(member)
                .recipe(recipe)
                .build();
        if (dto.getLike()){
            recipeLikeRepo.save(entity);
        } else{
            recipeLikeRepo.delete(entity);
        }
        return dto;

    }
}
