package com.example.vegan_life.controller;

import com.example.vegan_life.dto.RecipeDto;
import com.example.vegan_life.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping("/recipes")
    public ResponseEntity<RecipeDto> saveRecipe(@RequestBody RecipeDto dto) {
        RecipeDto result = recipeService.saveRecipe(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
