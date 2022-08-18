package com.example.vegan_life.service;

import com.example.vegan_life.dto.RecipeDto;
import com.example.vegan_life.entity.Recipe;
import com.example.vegan_life.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeDto save(RecipeDto dto) {
        Recipe saved = dto.toEntity();
        recipeRepository.save(saved);
        return RecipeDto.of(saved);
    }

    public List<RecipeDto> getAll() {
        List<Recipe> targets = recipeRepository.findAll();
        return RecipeDto.listOf(targets);
    }

    public RecipeDto get(Long id) {
        Recipe target = recipeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return RecipeDto.of(target);
    }
}
