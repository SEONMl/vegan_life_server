package com.example.vegan_life.controller;

import com.example.vegan_life.dto.ArticleLikeDto;
import com.example.vegan_life.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;


    @PostMapping("/article-like")
    public ResponseEntity<ArticleLikeDto> like(@RequestBody ArticleLikeDto dto){
        ArticleLikeDto result = likesService.articleLike(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article-like")
    public ResponseEntity<ArticleLikeDto> unHeart(@RequestBody ArticleLikeDto dto) {
        ArticleLikeDto result = likesService.articleUnLike(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
