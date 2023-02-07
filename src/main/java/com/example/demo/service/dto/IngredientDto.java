package com.example.demo.service.dto;

import com.example.demo.repository.entity.Ingredient;

public record IngredientDto(Long id, String name) {

    public static IngredientDto fromEntity(Ingredient ingredient){
        IngredientDto dto = new IngredientDto(
                ingredient.getId(),
                ingredient.getName());

        return dto;
    }

}