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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleLikeId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="article_id")
    private Article article;
}
