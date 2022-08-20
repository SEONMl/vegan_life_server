package com.example.vegan_life.dto;

import com.example.vegan_life.entity.enumclass.FoodCategory;
import com.example.vegan_life.entity.Recipe;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private String name_kor;
    private String nutrient;
    private String ingredient;
    private String cook_order;
    private FoodCategory foodCategory;


    public Recipe toEntity() {
        return Recipe.builder()
                .nameKor(name_kor)
                .nutrient(nutrient)
                .cookOrder(cook_order)
                .ingredient(ingredient)
                .foodCategory(foodCategory)
                .build();
    }

    public static RecipeDto of(Recipe recipe){
        return RecipeDto.builder()
                .name_kor(recipe.getNameKor())
                .nutrient(recipe.getNutrient())
                .cook_order(recipe.getCookOrder())
                .foodCategory(recipe.getFoodCategory())
                .ingredient(recipe.getIngredient())
                .build();
    }

    public static List<RecipeDto> listOf(List<Recipe> recipes) {
        return recipes.stream()
                .map(RecipeDto::of)
                .collect(Collectors.toList());
    }
}
