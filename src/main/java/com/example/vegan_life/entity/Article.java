package com.example.vegan_life.entity;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.entity.enumclass.CommunityCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="article")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private CommunityCode communityCode;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
    private LocalDateTime updatedAt;
    private LocalDateTime writtenAt;

    @OneToMany(mappedBy = "article",
                fetch = FetchType.LAZY)
    private List<ArticleLike> articleLikes = new ArrayList<>();

    @Builder
    public Article(String content, CommunityCode communityCode, Member member) {
        this.content = content;
        this.communityCode = communityCode;
        this.member = member;
        this.writtenAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public void update(ArticleDto dto) {
        this.content = dto.getContent();
        this.updatedAt = LocalDateTime.now();
    }
}
