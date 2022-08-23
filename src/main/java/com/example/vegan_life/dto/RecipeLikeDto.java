package com.example.vegan_life.dto;

import com.example.vegan_life.entity.Member;
import com.example.vegan_life.entity.Recipe;
import com.example.vegan_life.entity.RecipeLike;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RecipeLikeDto {
    private Long recipeId;
    private Boolean like;

    public RecipeLike toEntity(Recipe recipe, Member member){
        return new RecipeLike().builder()
                .recipe(recipe)
                .member(member)
                .build();
    }
}
