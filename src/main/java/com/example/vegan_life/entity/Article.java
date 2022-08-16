package com.example.vegan_life.entity;

import com.example.vegan_life.dto.ArticleRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    private String content;
    @Enumerated(EnumType.STRING)
    private CommunityCode communityCode;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
    private LocalDateTime updatedAt;
    private LocalDateTime writtenAt;

    @Builder
    public Article(String content, CommunityCode communityCode, Member member) {
        this.content = content;
        this.communityCode = communityCode;
        this.member = member;
        this.writtenAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(ArticleRequest dto) {
        this.content = dto.getContent();
        this.updatedAt = LocalDateTime.now();
    }
}
