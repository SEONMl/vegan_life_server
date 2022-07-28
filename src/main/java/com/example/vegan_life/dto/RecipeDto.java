package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private String name;
    private String nutrient;
    private String ingredient;
    private Boolean keep_recipe;
    private Cooking_Order cooking_order;
    // 이미지
}
