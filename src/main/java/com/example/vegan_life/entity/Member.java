package com.example.vegan_life.entity;

import com.example.vegan_life.dto.MemberRequest;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="member")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    private ActivationRatio activationRatio;

    public void setCreatedAt() {
        this.createdAt=LocalDateTime.now();
    }
    public void setUpdatedAt() {
        this.updatedAt=LocalDateTime.now();
    }


    // 이미지

}
