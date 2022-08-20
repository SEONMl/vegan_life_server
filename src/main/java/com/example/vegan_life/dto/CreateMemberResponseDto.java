package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberResponseDto {
    private String email;
    private String phone;
    private String name;
    private String nickname;
    private Integer height;
    private Integer weight;
    private String activationRatio;
    private String vegeType;
    // 이미지

    public static CreateMemberResponseDto of(Member member){
        return CreateMemberResponseDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .nickname(member.getNickname())
                .height(member.getHeight())
                .weight(member.getWeight())
                .vegeType(member.getVegeType().toString())
                .activationRatio(member.getActivationRatio().toString())
                .phone(member.getPhone())
                .build();
    }
}
