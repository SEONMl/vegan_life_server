package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.CommunityCode;
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
    private String community_code;
    private LocalDateTime written_at;
    private LocalDateTime updated_at;

    public Article toEntity() {
        return Article.builder()
                .communityCode(CommunityCode.valueOf(community_code))
                .content(content)
                .member(member)
                .build();
    }
    public static ArticleDto of(Article article){
        return ArticleDto.builder()
                .content(article.getContent())
                .community_code(article.getCommunityCode().toString())
                .written_at(article.getWrittenAt())
                .updated_at(article.getUpdatedAt())
                .build();
    }

    public static List<ArticleDto> lisfOf(List<Article> list){
        return list.stream()
                .map(ArticleDto::of)
                .collect(Collectors.toList());
    }
}