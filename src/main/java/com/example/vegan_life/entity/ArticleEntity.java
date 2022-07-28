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
    private Long article_idx;

    private String content;
    private int community_code;
    @ManyToOne
    private MemberEntity writer;
    private LocalDateTime updated_at;
    private LocalDateTime written_at;

    @Builder
    public ArticleEntity( String content, int community_code, MemberEntity writer) {
        this.content = content;
        this.community_code = community_code;
        this.writer = writer;
        this.written_at = LocalDateTime.now();
    }
}
