package com.example.vegan_life.entity;

import com.example.vegan_life.dto.ArticleDto;
import com.example.vegan_life.entity.enumclass.CommunityCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="article")
@NoArgsConstructor
@Getter
@AllArgsConstructor
@DynamicInsert
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

    @OneToMany(mappedBy = "article",
            fetch = FetchType.LAZY)
    private List<Comments> comments = new ArrayList<>();

    @Embedded
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();
    public void setUpdatedAt() {
        this.baseTimeEntity.update();
    }
    public void setDeleteAt() {
        this.baseTimeEntity.delete();
    }

    @OneToMany(mappedBy = "article",
                fetch = FetchType.LAZY)
    private List<ArticleLike> articleLikes = new ArrayList<>();

    @Builder
    public Article(String content, CommunityCode communityCode, Member member) {
        this.content = content;
        this.communityCode = communityCode;
        this.member = member;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public void setWriter(Member member){
        this.member = member;
    }

    public void updateContent(ArticleDto dto) {
        this.content = dto.getContent();
        setUpdatedAt();
    }

}
