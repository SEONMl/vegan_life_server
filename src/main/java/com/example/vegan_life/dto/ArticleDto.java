package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.enumclass.CommunityCode;
import com.example.vegan_life.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {
    private String writer;
    @Setter
    private Member member;
    private String content;
    private CommunityCode communityCode;
    private LocalDateTime writtenAt;
    private LocalDateTime updatedAt;

    public Article toEntity() {
        return Article.builder()
                .communityCode(communityCode)
                .content(content)
                .member(member)
                .build();
    }
    public static ArticleDto of(Article article){
        return ArticleDto.builder()
                .content(article.getContent())
                .communityCode(article.getCommunityCode())
                .writtenAt(article.getWrittenAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }

    public static List<ArticleDto> lisfOf(List<Article> list){
        return list.stream()
                .map(ArticleDto::of)
                .collect(Collectors.toList());
    }
}