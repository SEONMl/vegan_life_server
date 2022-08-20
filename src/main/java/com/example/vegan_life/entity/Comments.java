package com.example.vegan_life.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "article_id")
    private Article article;
    private String content;

    @OneToMany(mappedBy = "comments", fetch = FetchType.LAZY)
    private List<CommentLike> commentLikes = new ArrayList<>();
    private LocalDateTime writtenAt;
    private LocalDateTime updatedAt;

    @Builder
    public Comments(Member member, Article article, String content, LocalDateTime writtenAt) {
        this.member = member;
        this.article = article;
        this.content = content;
        this.writtenAt = LocalDateTime.now();
    }
}

