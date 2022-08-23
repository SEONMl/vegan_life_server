package com.example.vegan_life.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments_like")
@NoArgsConstructor
public class CommentLike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comments_id")
    private Comments comments;
    private Integer likeCount;

    @Builder
    public CommentLike(Comments comments, Integer likeCount) {
        this.comments = comments;
        this.likeCount = likeCount;
    }

    public void like() {
        this.likeCount++;
    }
    public void unlike() {
        this.likeCount--;
    }
}
