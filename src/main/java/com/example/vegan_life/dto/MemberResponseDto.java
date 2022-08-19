package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
    private String email;

    private String phone;
    private String name;
    private String nickname;
    private Integer height;
    private Integer weight;
    private String activationRatio;
    private String vegeType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // 이미지

    public static MemberResponseDto of(Member member){
        return MemberResponseDto.builder()
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
