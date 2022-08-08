package com.example.vegan_life.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="article")
@NoArgsConstructor
@Getter
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;

    private String content;
    private int community_code;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private MemberEntity member_id;
    private LocalDateTime updated_at;
    private LocalDateTime written_at;

    @Builder
    public ArticleEntity(String content, int community_code, MemberEntity member_id) {
        this.content = content;
        this.community_code = community_code;
        this.member_id = member_id;
        this.written_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }
}
