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
        ArticleEntity result = communityService.createArticle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/article/{article_id}")
    public ResponseEntity<ArticleEntity> readArticle(@PathVariable Long article_id) {
        ArticleEntity result = communityService.getArticle(article_id);
        if (result==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/article/{article_id}")
    public ResponseEntity patchArticle(@PathVariable Long article_id,
                                       @RequestBody ArticleDto dto) {
        ArticleEntity result = communityService.modifyArticle(article_id, dto);
        if (result == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article/{article_id}")
    public ResponseEntity deleteArticle(@PathVariable Long article_id){
        int result = communityService.deleteArticle(article_id);
        if (result==204){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        else if (result==404){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return null;
    }

    @PostMapping("/article/{article_id}")
    public ResponseEntity createComment(@PathVariable Long article_id,
                                        @RequestBody CommentDto dto) {
        CommentEntity result = communityService.createComment(article_id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/article/{article_id}/comments")
    public ResponseEntity getComments(@PathVariable Long article_id) {
        List<CommentEntity> result = communityService.getComments(article_id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article/{article_id}/comment/{comment_id}")
    public ResponseEntity deleteComment(@PathVariable Long article_id,
                                        @PathVariable Long comment_id) {
        int result = communityService.deleteComment(comment_id);
        if (result == 204) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } else if (result == 404) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return null;
    }

}
