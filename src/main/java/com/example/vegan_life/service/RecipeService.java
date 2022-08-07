package com.example.vegan_life.service;

import com.example.vegan_life.dto.RecipeDto;
import com.example.vegan_life.entity.RecipeEntity;
import com.example.vegan_life.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;


    public RecipeEntity saveRecipe(RecipeDto dto) {
        RecipeEntity saved = RecipeEntity.builder()
                .name_eng(dto.getName_eng())
                .name_kor(dto.getName_kor())
                .nutrient(dto.getNutrient())
                .cook_order(dto.getCook_order())
                .classification(dto.getClassification())
                .calorie(dto.getCalorie())
                .protein(dto.getProtein())
                .carbohydrate(dto.getCarbohydrate())
                .calcium(dto.getCalcium())
                .fat(dto.getFat())
                .vitamin(dto.getVitamin())
                .iron(dto.getIron())
                .ingredient(dto.getIngredient())
                .build();
        recipeRepository.save(saved);
        return saved;
    }
}
