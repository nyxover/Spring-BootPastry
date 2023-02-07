package com.example.demo.service;

import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.entity.Ingredient;
import com.example.demo.service.dto.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService {
@Autowired
    private IngredientRepository ingredientRepository;

public void addIngredient(Ingredient ingredient){
    ingredientRepository.save(ingredient);
    }

    public List<IngredientDto> fetchIngredients(){
    return ingredientRepository
            .findAll()
            .stream()
            .map(ingredient -> IngredientDto.fromEntity(ingredient))
            .collect(Collectors.toList());
}

    public Optional<IngredientDto> fetchById(Long id){
        return ingredientRepository
                .findById(id)
                .map(ingredient -> IngredientDto.fromEntity(ingredient));
                }

}

