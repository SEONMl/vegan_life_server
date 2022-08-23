package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Article;
import com.example.vegan_life.entity.Comments;
import com.example.vegan_life.entity.enumclass.CommunityCode;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class SelectedArticleResponseDto {
    private Long article_id;
    private String writer;
    private String content;
    private CommunityCode communityCode;
    private List<CommentDto> commentDtoList;

    @Builder
    public SelectedArticleResponseDto(Long article_id, String writer, String content, CommunityCode communityCode, List<CommentDto> commentDtoList) {
        this.article_id = article_id;
        this.writer = writer;
        this.content = content;
        this.communityCode = communityCode;
        this.commentDtoList = commentDtoList;
    }

    public static SelectedArticleResponseDto of(Article target, List<Comments> commentsList) {
        return SelectedArticleResponseDto.builder()
                .article_id(target.getId())
                .writer(target.getMember().getNickname())
                .commentDtoList(CommentDto.listOf(commentsList))
                .communityCode(target.getCommunityCode())
                .build();
    }
}
