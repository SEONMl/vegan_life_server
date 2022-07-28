package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long member_idx;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private Float height;
    private Float weight;
    private String vege_type;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    // 이미지
}
