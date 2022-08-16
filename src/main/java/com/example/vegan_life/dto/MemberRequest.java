package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Member;
import com.example.vegan_life.entity.VegeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private Long member_id;

    private String email;
    private String phone;
    @Setter
    private String password;
    private String name;
    private String nickname;
    private Float height;
    private Float weight;
    private String vege_type;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
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
                .vegeType(VegeType.valueOf(vege_type))
                .build();
    }
}