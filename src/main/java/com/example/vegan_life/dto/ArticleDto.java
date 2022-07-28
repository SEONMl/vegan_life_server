package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private Long article_idx;
    private String content;
    private int community_code;
    private MemberDto writer;
    private LocalDateTime written_at;
    private LocalDateTime updated_at;
}
