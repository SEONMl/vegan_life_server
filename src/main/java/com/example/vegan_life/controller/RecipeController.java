package com.example.vegan_life.controller;

import com.example.vegan_life.dto.RecipeDto;
import com.example.vegan_life.entity.RecipeEntity;
import com.example.vegan_life.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RecipeController {
    @Autowired
    RecipeService recipeService;

    //@GetMapping("/recipes")
    //public RecipeEntity getRecipes(@RequestBody Map<String, Long> member_id){}

    @PostMapping("/recipes")
    public ResponseEntity saveRecipe(@RequestBody RecipeDto dto) {
        RecipeEntity result = recipeService.saveRecipe(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
