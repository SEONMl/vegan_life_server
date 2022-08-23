package com.example.vegan_life.dto;

import com.example.vegan_life.entity.CommentLike;
import com.example.vegan_life.entity.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentLikeDto {
    private Long memberId;
    private Long commentId;
    private Boolean like;

    @Builder
    public CommentLikeDto(Long memberId, Long commentId, Boolean like) {
        this.memberId = memberId;
        this. commentId = commentId;
        this.like = like;
    }

    public  CommentLike toEntity(Comments comments) {
        return CommentLike.builder()
                .comments(comments)
                .build();
    }
}
