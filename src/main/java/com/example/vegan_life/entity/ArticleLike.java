package com.example.vegan_life.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="article_like")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id")
    private Article article;

    @Builder.Default
    private Integer likeCount=0;

    @Builder
    public ArticleLike(Article article, Integer likeCount) {
        this.article = article;
        this.likeCount = likeCount;
    }

    public void like() {
        this.likeCount++;
    }
    public void unlike() {
        this.likeCount--;
    }
}

