package com.example.vegan_life.controller;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentRequestDto;
import com.example.vegan_life.dto.CommentResponseDto;
import com.example.vegan_life.dto.SelectedArticleResponseDto;
import com.example.vegan_life.service.CommunityService;
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

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> readAll() {
        List<ArticleDto> result = communityService.getAllArticles();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/articles")
    public ResponseEntity<ArticleDto> create(@RequestBody ArticleDto dto) {
        ArticleDto result = communityService.createArticle(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/article/{articleId}")
    public ResponseEntity<SelectedArticleResponseDto> read(@PathVariable Long articleId) {
        SelectedArticleResponseDto result = communityService.getArticle(articleId);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/article/{articleId}") // 작성자 아닐 때 수정 금지
    public ResponseEntity<Void> patchContent(@PathVariable Long articleId,
                                                   @RequestBody ArticleDto dto) {
        communityService.modifyArticle(articleId, dto);
        return ResponseEntity.ok().build();
    }
    @PatchMapping("/comment/{commentId}") // 작성자 아닐 때 수정 금지
    public ResponseEntity<Void> patchContent(@PathVariable Long commentId,
                                             @RequestBody CommentRequestDto dto) {
        communityService.modifyComment(commentId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/article/{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId) {
        communityService.deleteArticle(articleId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/article/{articleId}")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long articleId,
                                                    @RequestBody CommentRequestDto dto) {
        CommentResponseDto result = communityService.createComment(articleId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/article/{articleId}/comment/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long articleId,
                                              @PathVariable Long commentId) {
        communityService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

}
