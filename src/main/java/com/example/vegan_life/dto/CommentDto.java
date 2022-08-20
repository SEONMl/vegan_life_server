package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.Comments;
import com.example.vegan_life.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private Long comment_id;
    private Long article_id;
    @Setter
    private Article article;
    private String writer;
    @Setter
    private Member member;

    private String content;
    private LocalDateTime writtenAt;
    private LocalDateTime updatedAt;

    public static List<CommentDto> listOf(List<Comments> targets) {
        return targets.stream()
                .map(CommentDto::of)
                .collect(Collectors.toList());
    }

    public Comments toEntity(){
        return Comments.builder()
                .content(content)
                .article(article)
                .member(member)
                .build();
    }

    public static CommentDto of(Comments comments){
        return CommentDto.builder()
                .writer(comments.getMember().getNickname())
                .content(comments.getContent())
                .writtenAt(comments.getWrittenAt())
                .updatedAt(comments.getUpdatedAt())
                .build();
    }


}
