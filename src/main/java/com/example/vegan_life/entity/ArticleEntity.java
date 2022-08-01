package com.example.vegan_life.entity;

import com.example.vegan_life.dto.MemberDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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
    @ManyToOne
    private MemberEntity member_id;
    private LocalDateTime updated_at;
    private LocalDateTime written_at;

    @Builder
    public ArticleEntity(String content, int community_code, MemberEntity member_id) {
        this.content = content;
        this.community_code = community_code;
        this.member_id = member_id;
        this.written_at = LocalDateTime.now();
    }
}
