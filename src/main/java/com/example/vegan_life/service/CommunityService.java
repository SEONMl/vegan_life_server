package com.example.vegan_life.service;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.dto.CommentDto;
import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.Comment;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.repository.ArticleRepository;
import com.example.vegan_life.repository.CommentRepository;
import com.example.vegan_life.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public ArticleDto createArticle(ArticleDto dto) {
        Member target = memberRepository.findByEmail(dto.getWriter()).orElseThrow(EntityNotFoundException::new);
        dto.setMember(target);
        Article saved = dto.toEntity();
        articleRepository.save(saved);
        return ArticleDto.of(saved);
    }

    public List<ArticleDto> getAllArticles() {
        List<Article> targets = articleRepository.findAll();
        return ArticleDto.lisfOf(targets);
    }

    public CommentDto createComment(Long article_id, CommentDto dto) {
        Article parentArticle = articleRepository.findById(article_id).orElseThrow(EntityNotFoundException::new);
        Member member = memberRepository.findByEmail(dto.getWriter()).orElseThrow(EntityNotFoundException::new);
        dto.setArticle(parentArticle);
        dto.setMember(member);
        Comment saved = dto.toEntity();
        commentRepository.save(saved);
        return CommentDto.of(saved);
    }

    public ArticleDto getArticle(Long article_id) {
        Article target = articleRepository.findById(article_id).orElseThrow(EntityNotFoundException::new);
        return ArticleDto.of(target);
    }

    public ArticleDto modifyArticle(Long article_id, ArticleDto dto) {
        Article target = articleRepository.findById(article_id).orElseThrow(EntityNotFoundException::new);
        target.update(dto);

        return ArticleDto.of(target);
    }

    public void deleteArticle(Long article_id) {
        articleRepository.deleteById(article_id);
    }

    public void deleteComment(Long comment_id) {
        commentRepository.deleteById(comment_id);
    }

    public List<CommentDto> getComments(Long article_id) {
        List<Comment> targets =commentRepository.findAllByArticleId(article_id).orElseThrow(EntityNotFoundException::new);
        return CommentDto.listOf(targets);
    }
}
