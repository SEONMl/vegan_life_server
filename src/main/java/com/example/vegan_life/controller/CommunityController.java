package com.example.vegan_life.controller;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentDto;
import com.example.vegan_life.service.CommunityService;
import com.example.vegan_life.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community")
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;
    private final MemberService memberService;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> readAll() {
        List<ArticleDto> result = communityService.getAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleDto> create(@RequestBody ArticleDto dto) {
        ArticleDto result = communityService.createArticle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/article/{article_id}")
    public ResponseEntity<ArticleDto> read(@PathVariable Long article_id) {
        ArticleDto result = communityService.getArticle(article_id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/article/{article_id}")
    public ResponseEntity<ArticleDto> patchContent(@PathVariable Long article_id,
                                                   @RequestBody ArticleDto dto) {
        ArticleDto result = communityService.modifyArticle(article_id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article/{article_id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long article_id) {
        communityService.deleteArticle(article_id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/article/{article_id}")
    public ResponseEntity<CommentDto> createComment(@PathVariable Long article_id,
                                                    @RequestBody CommentDto dto) {
        CommentDto result = communityService.createComment(article_id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/article/{article_id}/comments")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long article_id) {
        List<CommentDto> result = communityService.getComments(article_id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article/{article_id}/comment/{comment_id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long article_id,
                                              @PathVariable Long comment_id) {
        communityService.deleteComment(comment_id);
        return ResponseEntity.noContent().build();
    }

}
