package com.example.vegan_life.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="comment")
@Getter
@NoArgsConstructor
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    @ManyToOne
    private MemberEntity member_id;
    @ManyToOne
    private ArticleEntity article_id;
    private String content;
    private LocalDateTime written_at;
    private LocalDateTime updated_at;

    @Builder
    public CommentEntity(MemberEntity member_id, ArticleEntity article_id,String content, LocalDateTime written_at) {
        this.member_id = member_id;
        this.article_id = article_id;
        this.content = content;
        this.written_at = LocalDateTime.now();
    }
}

