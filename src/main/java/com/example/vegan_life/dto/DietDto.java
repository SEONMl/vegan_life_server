package com.example.vegan_life.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DietDto {
    private String nameKor;
    private Integer calorie;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;
    private Integer calcium;
    private Integer vitamin;
    private Integer iron;
}
