package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.Comments;
import com.example.vegan_life.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CommentResponseDto {
    private Long article_id;
    private Long comment_id;

    private String writer;
    private String content;

    @Builder
    public CommentResponseDto(Long article_id, Long comment_id, String writer, String content) {
        this.article_id = article_id;
        this.comment_id = comment_id;
        this.writer = writer;
        this.content = content;
    }

    public static List<CommentResponseDto> listOf(List<Comments> targets) {
        return targets.stream()
                .map(CommentResponseDto::of)
                .collect(Collectors.toList());
    }

    public Comments toEntity(){
        return Comments.builder()
                .content(content)
                .build();
    }

    public static CommentResponseDto of(Comments comments){
        return CommentResponseDto.builder()
                .comment_id(comments.getId())
                .article_id(comments.getArticle().getId())
                .writer(comments.getMember().getNickname())
                .content(comments.getContent())
                .build();
    }
}
