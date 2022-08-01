package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long comment_id;
    private Long article_id;

    private String content;
    private LocalDateTime written_at;
    private LocalDateTime updated_at;
    private String writer;
    private Long member_id;
}
