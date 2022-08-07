package com.example.vegan_life.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="recipe")
@Getter
@NoArgsConstructor
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipe_id;

    private String name_kor;
    private String name_eng;
    private String nutrient;
    private String ingredient;
    private String cook_order;
    private String classification;

    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float fat;
    private Float calcium;
    private Float vitamin;
    private Float iron;

    private LocalDateTime intake_time;

    @Builder
    public RecipeEntity( String name_kor, String name_eng, String nutrient, String ingredient, String cook_order, String classification, Float calorie, Float carbohydrate, Float protein, Float fat, Float calcium, Float vitamin, Float iron) {
        this.name_kor = name_kor;
        this.name_eng = name_eng;
        this.nutrient = nutrient;
        this.ingredient = ingredient;
        this.cook_order = cook_order;
        this.classification = classification;
        this.calorie = calorie;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.calcium = calcium;
        this.vitamin = vitamin;
        this.iron = iron;
        this.intake_time = LocalDateTime.now();
    }
}
