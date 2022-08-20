package com.example.vegan_life.entity;

import com.example.vegan_life.entity.enumclass.Meal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "life_check")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LifeCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "life_check_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime intake_time;

    @OneToMany(mappedBy = "lifeCheck",
            fetch = FetchType.LAZY)
    private List<Diet> diets = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Meal meal;
}
