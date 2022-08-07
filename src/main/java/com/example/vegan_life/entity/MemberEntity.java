package com.example.vegan_life.entity;

import com.example.vegan_life.dto.MemberDto;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(unique = true)
    @NotNull
    private String email;
    @Column(unique = true)
    private String phone;
    @NotNull
    private String password;
    private String name;
    private String nickname;
    private Float height;
    private Float weight;
    private String vege_type;
    private LocalDateTime updated_at;
    private LocalDateTime created_at;
    // 이미지


    @Builder
    public MemberEntity(String email, String password, String name, String nickname, Float height, Float weight, String vege_type) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.vege_type = vege_type;
        this.created_at = LocalDateTime.now();
    }

    public void update(MemberDto dto) {
        this.password = dto.getPassword();
        this.name = dto.getName();
        this.nickname = dto.getNickname();
        this.height = dto.getHeight();
        this.weight = dto.getWeight();
        this.vege_type = dto.getVege_type();
        this.updated_at = LocalDateTime.now();
    }
}
