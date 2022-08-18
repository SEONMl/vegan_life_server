package com.example.vegan_life.controller;

import com.example.vegan_life.dto.ArticleLikeDto;
import com.example.vegan_life.service.ArticleLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LikesController {

    private final ArticleLikeService articleLikeService;


    @PostMapping("/article/like")
    public ResponseEntity<ArticleLikeDto> like(@RequestBody ArticleLikeDto dto){
        ArticleLikeDto result = articleLikeService.like(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article/like")
    public ResponseEntity<ArticleLikeDto> unHeart(@RequestBody ArticleLikeDto dto) {
        ArticleLikeDto result = articleLikeService.unLike(dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
