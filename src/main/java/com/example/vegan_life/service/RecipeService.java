package com.example.vegan_life.service;

import com.example.vegan_life.dto.RecipeDto;
import com.example.vegan_life.entity.Recipe;
import com.example.vegan_life.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeDto saveRecipe(RecipeDto dto) {
        Recipe saved = dto.toEntity();
        recipeRepository.save(saved);
        return RecipeDto.of(saved);
    }
}
