package com.example.vegan_life.controller;

import com.example.vegan_life.dto.ArticleLikeDto;
import com.example.vegan_life.dto.CommentLikeDto;
import com.example.vegan_life.dto.RecipeLikeDto;
import com.example.vegan_life.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;


    @PostMapping("/article-like")
    public ResponseEntity<ArticleLikeDto> like(@RequestBody ArticleLikeDto dto) {
        ArticleLikeDto result = likesService.articleLike(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/comment-like")
    public ResponseEntity<CommentLikeDto> like(@RequestBody CommentLikeDto dto) {
        CommentLikeDto result = likesService.commentLike(dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/article-like") // 미구현
    public ResponseEntity<ArticleLikeDto> unHeart(@RequestBody ArticleLikeDto dto) {
        ArticleLikeDto result = likesService.articleUnLike(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/recipe-like")
    public ResponseEntity<RecipeLikeDto> like(@RequestBody RecipeLikeDto dto) {
        RecipeLikeDto result = likesService.recipeLike(dto);
        return ResponseEntity.ok(result);
    }
}
