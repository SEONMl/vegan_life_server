package com.example.vegan_life.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="diet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Diet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="diet_id")
    private Long diet_id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="life_check_id")
    private LifeCheck lifeCheck;

    private String name_kor;
    private String name_eng;
    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float fat;
    private Float calcium;
    private Float vitamin;
    private Float iron;
}
