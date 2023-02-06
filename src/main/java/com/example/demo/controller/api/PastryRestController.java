package com.example.demo.controller.api;

import com.example.demo.repository.PastryRepository;
import com.example.demo.repository.entity.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pastries")
public class PastryRestController {
    @Autowired
    private PastryRepository pastryRepository;

    @GetMapping
    public List<Pastry> displayAllPastries() {
        List<Pastry> pastryList = (List<Pastry>) pastryRepository.findAll();
        return pastryList;
    }
}
