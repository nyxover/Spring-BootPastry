package com.example.demo.controller;

import com.example.demo.repository.PastryRepository;
import com.example.demo.repository.entity.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private PastryRepository pastryRepository;

    @GetMapping("/search")
    public String searchPastries(@RequestParam("searchTerm") String searchTerm, Model model) {
        List<Pastry> pastries = pastryRepository.findByNameContainingIgnoreCase(searchTerm);
        model.addAttribute("pastries", pastries);
        return "search-results.html";
    }

}
