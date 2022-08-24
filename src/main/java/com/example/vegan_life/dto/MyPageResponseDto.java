package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Member;
import com.example.vegan_life.entity.enumclass.VegeType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MyPageResponseDto {
    private String nickname;
    private String email;
    private List<RecipeDto> recipeList;

    @Builder
    public MyPageResponseDto(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public static MyPageResponseDto of(Member member) {
        return MyPageResponseDto.builder()
                .nickname(member.getNickname())
                .email(member.getEmail())
                .build();
    }
}
