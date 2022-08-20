package com.example.vegan_life.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private Integer likes;
}
