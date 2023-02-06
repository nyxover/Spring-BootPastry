package com.example.demo.service.dto;

import com.example.demo.repository.entity.Pastry;

import java.util.Date;

public record PastryDto(Long id, String name, String description, Date date) {

    public static PastryDto fromEntity(Pastry pastry){
        PastryDto dto = new PastryDto(
                pastry.getId(),
                pastry.getName(),
                pastry.getDescription(),
                pastry.getDate());
        return dto;
    }

}