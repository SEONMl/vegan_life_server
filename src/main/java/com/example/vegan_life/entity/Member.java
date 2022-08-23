package com.example.vegan_life.entity;

import com.example.vegan_life.entity.enumclass.ActivationRatio;
import com.example.vegan_life.entity.enumclass.VegeType;
import com.example.vegan_life.security.auth.Authority;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

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
    private Integer height;
    private Integer weight;

    @Enumerated(EnumType.STRING)
    private VegeType vegeType;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    @Embedded
    @Builder.Default
    private BaseTimeEntity baseTimeEntity = new BaseTimeEntity();

    @Enumerated(EnumType.STRING)
    private ActivationRatio activationRatio;

    @OneToMany(mappedBy = "member",
            fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "member",
            fetch = FetchType.LAZY)
    private List<Comments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "member",
            fetch = FetchType.LAZY)
    private List<RecipeLike> recipelikes = new ArrayList<>();


    public void setUpdatedAt() {
        this.baseTimeEntity.update();
    }
    public void setDeleteAt() {
        this.baseTimeEntity.delete();
    }

    @Builder
    public Member(String email, String password, Authority authority) {
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}
