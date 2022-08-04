package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
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
}
