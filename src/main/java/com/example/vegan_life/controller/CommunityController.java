package com.example.vegan_life.controller;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentDto;
import com.example.vegan_life.entity.ArticleEntity;
import com.example.vegan_life.entity.CommentEntity;
import com.example.vegan_life.service.CommunityService;
import com.example.vegan_life.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
public class CommunityController {
    @Autowired
    CommunityService communityService;
    @Autowired
    MemberService memberService;

    @GetMapping("/articles")
    public ResponseEntity readArticles() {
        List<ArticleEntity> result = communityService.getAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/articles")
    public ResponseEntity createArticle(@RequestBody ArticleDto dto) {
        ArticleEntity reuslt = communityService.createArticle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(reuslt);
    }

    @GetMapping("/article/{article_id}")
    public ResponseEntity readArticle(@PathVariable Long article_id) {
        ArticleEntity result = communityService.getArticle(article_id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/article/{article_id}")
    public ResponseEntity patchArticle(@PathVariable Long article_id,
                                       @RequestBody ArticleDto dto) {
        ArticleEntity result = communityService.modifyArticle(article_id, dto);
        if (result == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/article/{article_id}")
    public ResponseEntity createComment(@PathVariable Long article_id,
                                        @RequestBody CommentDto dto) {
        CommentEntity result = communityService.createComment(article_id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
