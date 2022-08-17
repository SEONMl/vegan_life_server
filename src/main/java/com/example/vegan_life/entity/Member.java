package com.example.vegan_life.entity;

import com.example.vegan_life.dto.MemberRequest;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Getter
@NoArgsConstructor
@DynamicInsert
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long member_id;

    @Column(unique = true)
    @NotNull
    private String email;
    @Column(unique = true)
    @NotNull
    private String phone;
    @NotNull
    @Setter
    private String password;
    private String name;
    private String nickname;
    private Float height;
    private Float weight;
    @Enumerated(EnumType.STRING)
    private VegeType vegeType;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    // 이미지


    @Builder
    public Member(String email, String phone, String password, String name, String nickname, Float height, Float weight, VegeType vegeType) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.nickname = nickname;
        this.height = height;
        this.weight = weight;
        this.vegeType = vegeType;
        this.createdAt = LocalDateTime.now();
    }


}
