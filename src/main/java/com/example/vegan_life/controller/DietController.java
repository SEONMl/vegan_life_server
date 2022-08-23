package com.example.vegan_life.controller;

import com.example.vegan_life.dto.CreateRequestDietDto;
import com.example.vegan_life.service.DietService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diet")
@RequiredArgsConstructor
public class DietController {
    private final DietService dietService;

    @PostMapping()
    public ResponseEntity<CreateRequestDietDto> save(@RequestBody CreateRequestDietDto dto){
        CreateRequestDietDto result = dietService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
