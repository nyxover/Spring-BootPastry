package com.example.demo.service.dto;

import com.example.demo.repository.entity.Pastry;

public record PastryDto(Long id, String name, String description) {

    public static PastryDto fromEntity(Pastry pastry){
        PastryDto dto = new PastryDto(
                pastry.getId(),
                pastry.getName(),
                pastry.getDescription());
        return dto;
    }

}