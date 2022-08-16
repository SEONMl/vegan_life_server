package com.example.vegan_life.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="member_id")
    private Member member;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="article_id")
    private Article article;
    private String content;
    private LocalDateTime writtenAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comment(Member member, Article article, String content, LocalDateTime writtenAt) {
        this.member = member;
        this.article = article;
        this.content = content;
        this.writtenAt = LocalDateTime.now();
    }
}

