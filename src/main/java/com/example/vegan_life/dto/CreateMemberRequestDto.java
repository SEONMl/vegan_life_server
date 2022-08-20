package com.example.vegan_life.dto;

import com.example.vegan_life.entity.enumclass.ActivationRatio;
import com.example.vegan_life.entity.Member;
import com.example.vegan_life.entity.enumclass.VegeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequestDto {
    private String email;
    private String phone;
    @Setter
    private String password;
    private String name;
    private String nickname;
    private Integer height;
    private Integer weight;
    private ActivationRatio activationRatio;
    private VegeType vegeType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Member member;
    // 이미지

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .height(height)
                .weight(weight)
                .phone(phone)
                .email(email)
                .password(password)
                .vegeType(vegeType)
                .activationRatio(activationRatio)
                .build();
    }
}
