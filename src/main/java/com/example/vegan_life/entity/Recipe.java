package com.example.vegan_life.entity;

import com.example.vegan_life.entity.enumclass.FoodCategory;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipe")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @NotNull
    private String nameKor;
    private String nutrient;
    private String ingredient;
    private String cookOrder;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @OneToMany(mappedBy = "recipe_like",
            fetch = FetchType.LAZY)
    private List<RecipeLike> recipeLike;
}
