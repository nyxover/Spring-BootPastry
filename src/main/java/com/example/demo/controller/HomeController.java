package com.example.demo.controller;

import com.example.demo.repository.PastryRepository;
import com.example.demo.repository.entity.Pastry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class HomeController {

    private PastryRepository pastryRepository;

    public HomeController(PastryRepository pastryRepository){
        this.pastryRepository = pastryRepository;
    }
@GetMapping("/home")
    public String home(Model model) {
        List<Pastry> pastryList = (List<Pastry>) pastryRepository.findAll();
        model.addAttribute("pastries", pastryList);
        return "home";
    }



}
