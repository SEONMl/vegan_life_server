package com.example.vegan_life.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    private Integer height;
    private Integer weight;

    @Enumerated(EnumType.STRING)
    private VegeType vegeType;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private ActivationRatio activationRatio;

    @OneToMany(mappedBy = "article",
            fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "comment",
            fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "recipe",
                fetch = FetchType.LAZY)
    private List<Recipe> recipes = new ArrayList<>();

    public void setCreatedAt() {
        this.createdAt=LocalDateTime.now();
    }
    public void setUpdatedAt() {
        this.updatedAt=LocalDateTime.now();
    }
}
