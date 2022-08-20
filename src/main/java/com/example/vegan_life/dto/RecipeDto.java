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
    private String name_eng;
    private String nutrient;
    private String ingredient;
    private String cook_order;
    private FoodCategory foodCategory;

    private Integer calorie;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;
    private Integer calcium;
    private Integer vitamin;
    private Integer iron;

    public Recipe toEntity() {
        return Recipe.builder()
                .nameKor(name_kor)
                .nutrient(nutrient)
                .cookOrder(cook_order)
                .ingredient(ingredient)
                .foodCategory(foodCategory)
                .calorie(calorie)
                .protein(protein)
                .fat(fat)
                .vitamin(vitamin)
                .iron(iron)
                .build();
    }

    public static RecipeDto of(Recipe recipe){
        return RecipeDto.builder()
                .name_eng(recipe.getNameEng())
                .name_kor(recipe.getNameKor())
                .nutrient(recipe.getNutrient())
                .cook_order(recipe.getCookOrder())
                .calorie(recipe.getCalorie())
                .calcium(recipe.getCalcium())
                .fat(recipe.getFat())
                .protein(recipe.getProtein())
                .foodCategory(recipe.getFoodCategory())
                .ingredient(recipe.getIngredient())
                .iron(recipe.getIron())
                .vitamin(recipe.getVitamin())
                .build();
    }

    public static List<RecipeDto> listOf(List<Recipe> recipes) {
        return recipes.stream()
                .map(RecipeDto::of)
                .collect(Collectors.toList());
    }
}
