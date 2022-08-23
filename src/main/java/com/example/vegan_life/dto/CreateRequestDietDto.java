package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Diet;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateRequestDietDto {
    private String name;
    private Integer calorie;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;

    public Diet toEntity() {
        return Diet.builder()
                .name(name)
                .calorie(calorie)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .fat(fat)
                .build();
    }

    @Builder
    public CreateRequestDietDto(Diet diet) {
        this.name = diet.getName();
        this.calorie = diet.getCalorie();
        this.carbohydrate = diet.getCarbohydrate();
        this.protein = diet.getProtein();
        this.fat = diet.getFat();
    }
}
