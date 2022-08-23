package com.example.vegan_life.service;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentDto;
import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.Comments;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.CommentRepository;
import com.example.vegan_life.repository.MemberRepository;
import com.example.vegan_life.security.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public CommentDto createComment(Long article_id, CommentDto dto) {
        String curUser = CustomUserDetailsService.getCurUser();
        Article parentArticle = articleRepository.findById(article_id).orElseThrow(EntityNotFoundException::new);
        Member writer = memberRepository.findByEmail(curUser).orElseThrow(EntityNotFoundException::new);

        Comments entity = dto.toEntity();
        entity.setArticleAndWriter(parentArticle, writer);

        commentRepository.save(entity);
        return CommentDto.of(entity);
    }

    public ArticleDto getArticle(Long article_id) {
        Article target = articleRepository.findById(article_id).orElseThrow(EntityNotFoundException::new);
        return ArticleDto.of(target);
    }

    @Transactional
    public ArticleDto modifyArticle(Long article_id, ArticleDto dto) {
        Article target = articleRepository.findById(article_id).orElseThrow(EntityNotFoundException::new);
        target.updateContent(dto);
        return ArticleDto.of(target);
    }
    @Transactional
    public CommentDto modifyComment(Long comment_id, CommentDto dto) {
        Comments target = commentRepository.findById(comment_id).orElseThrow(EntityNotFoundException::new);
        target.updateContent(dto);

        return CommentDto.of(target);
    }

    public void deleteArticle(Long article_id) {
        articleRepository.deleteById(article_id);
    }

    public void deleteComment(Long comment_id) {
        commentRepository.deleteById(comment_id);
    }

    public List<CommentDto> getComments(Long article_id) {
        List<Comments> targets = commentRepository.findAllByArticleId(article_id).orElseThrow(EntityNotFoundException::new);
        return CommentDto.listOf(targets);
    }
}
