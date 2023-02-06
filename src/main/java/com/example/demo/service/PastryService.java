package com.example.demo.service;

import com.example.demo.repository.PastryRepository;
import com.example.demo.repository.entity.Pastry;
import com.example.demo.service.dto.PastryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PastryService {
@Autowired
    private PastryRepository pastryRepository;

public void addPastry(Pastry pastry){
        pastryRepository.save(pastry);
    }

    public List<PastryDto> fetchPastries(){
    return pastryRepository
            .findAll()
            .stream()
            .map(pastry -> PastryDto.fromEntity(pastry))
            .collect(Collectors.toList());
}

    public Optional<PastryDto> fetchById(Long id){
        return pastryRepository
                .findById(id)
                .map(pastry -> PastryDto.fromEntity(pastry));
                }

}

