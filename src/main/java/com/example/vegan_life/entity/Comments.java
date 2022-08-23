package com.example.vegan_life.entity;

import com.example.vegan_life.dto.CommentRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor
@DynamicInsert
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

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();
    public void setUpdatedAt() {
        this.baseTimeEntity.update();
    }
    public void setDeleteAt() {
        this.baseTimeEntity.delete();
    }

    @Builder
    public Comments(Member member, Article article, String content, LocalDateTime writtenAt) {
        this.member = member;
        this.article = article;
        this.content = content;
    }

    public void updateContent(CommentRequestDto dto) { // TODO Optional로 변경
        this.content = dto.getContent();
        setUpdatedAt();
    }

    public void setArticleAndWriter(Article parentArticle, Member writer) {
        this.article=parentArticle;
        this.member=writer;
    }
}

