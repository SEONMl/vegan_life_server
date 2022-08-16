package com.example.vegan_life.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @NotNull
    private String nameKor;
    private String nameEng;
    private String nutrient;
    private String ingredient;
    private String cookOrder;
    private String classification;

    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float fat;
    private Float calcium;
    private Float vitamin;
    private Float iron;

    private LocalDateTime intakeTime;



}
