package com.example.vegan_life.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="recipe_like")
@NoArgsConstructor
public class RecipeLike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recipe_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="recipe_id")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
}
