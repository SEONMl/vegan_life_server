package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.ArticleLike;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ArticleLikeDto {
    private Long memberId;
    private Long articleId;
    private Boolean like;

    @Builder
    public ArticleLikeDto(Long memberId, Long articleId, Boolean like) {
        this.memberId = memberId;
        this.articleId = articleId;
        this.like = like;
    }

    public ArticleLike toEntity(Article article) {
        return ArticleLike.builder()
                .article(article)
                .build();
    }
}
