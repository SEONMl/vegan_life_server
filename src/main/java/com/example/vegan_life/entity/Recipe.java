package com.example.vegan_life.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="recipe")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="recipe_id")
    private Long recipe_id;

    @NotNull
    private String nameKor;
    private String nutrient;
    private String ingredient;
    private String cookOrder;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;
}
