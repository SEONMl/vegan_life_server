package com.example.vegan_life.controller;

import com.example.vegan_life.dto.RecipeDto;
import com.example.vegan_life.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping("/recipes")
    public ResponseEntity<List<RecipeDto>> getAll(){
        List<RecipeDto> result = recipeService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @PostMapping("/recipes")
    public ResponseEntity<RecipeDto> saveRecipe(@RequestBody RecipeDto dto) {
        RecipeDto result = recipeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeDto> get(@PathVariable Long id){
        RecipeDto result = recipeService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
