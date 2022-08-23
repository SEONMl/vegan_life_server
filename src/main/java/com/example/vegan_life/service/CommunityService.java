package com.example.vegan_life.service;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentRequestDto;
import com.example.vegan_life.dto.CommentResponseDto;
import com.example.vegan_life.dto.SelectedArticleResponseDto;
import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.Comments;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.CommentRepository;
import com.example.vegan_life.repository.MemberRepository;
import com.example.vegan_life.security.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommunityService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public ArticleDto createArticle(ArticleDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Member writer = memberRepository.findByEmail(curUser).orElseThrow(EntityNotFoundException::new);

        Article entity = dto.toEntity();
        entity.setWriter(writer);
        articleRepository.save(entity);
        return ArticleDto.of(entity);
    }

    public List<ArticleDto> getAllArticles() {
        log.info("CustomUserDetailsService.getCurUser() : "+ CustomUserDetailsService.getCurUser());

        List<Article> targets = articleRepository.findAll();
        return ArticleDto.lisfOf(targets);
    }

    public CommentResponseDto createComment(Long articleId, CommentRequestDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Article parentArticle = articleRepository.findById(articleId).orElseThrow(EntityNotFoundException::new);
        Member writer = memberRepository.findByEmail(curUser).orElseThrow(EntityNotFoundException::new);

        Comments entity = dto.toEntity();
        entity.setArticleAndWriter(parentArticle, writer);

        commentRepository.save(entity);
        return CommentResponseDto.of(entity);
    }

    public SelectedArticleResponseDto getArticle(Long articleId) {
        Article target = articleRepository.findById(articleId).orElseThrow(EntityNotFoundException::new);
        List<Comments> commentsList = commentRepository.findAllByArticleId(articleId).orElse(null);
        return SelectedArticleResponseDto.of(target, CommentResponseDto.listOf(commentsList));
    }

    @Transactional
    public void modifyArticle(Long articleId, ArticleDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Article target = articleRepository.findById(articleId).orElseThrow(EntityNotFoundException::new);
        if (!target.getMember().getEmail().equals(curUser)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        target.updateContent(dto);
    }
    @Transactional
    public void modifyComment(Long commentId, CommentRequestDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Comments target = commentRepository.findById(commentId).orElseThrow(EntityNotFoundException::new);
        if (!target.getMember().getEmail().equals(curUser)) throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        target.updateContent(dto);
    }

    public void deleteArticle(Long articleId) {
        articleRepository.deleteById(articleId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<CommentResponseDto> getComments(Long articleId) {
        List<Comments> targets = commentRepository.findAllByArticleId(articleId).orElseThrow(EntityNotFoundException::new);
        return CommentResponseDto.listOf(targets);
    }
}
