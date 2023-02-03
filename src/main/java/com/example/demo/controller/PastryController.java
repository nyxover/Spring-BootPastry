package com.example.demo.controller;

import com.example.demo.repository.PastryRepository;
import com.example.demo.repository.entity.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PastryController {
    @Autowired
    private PastryRepository pastryRepository;
    @GetMapping("/all")
    public String displayAllPastry(Model model) {
        List<Pastry> pastryList = (List<Pastry>) pastryRepository.findAll();
        model.addAttribute("pastries", pastryList);
        return "home.html";
    }
    @GetMapping ("/add")
    public String displayAddPastryForm(Model model) {
    Pastry pastry = new Pastry();
    model.addAttribute("pastry", pastry);
    return "add-pastry";
    }
 /*  @PostMapping("/add")
    public String addPastry(@RequestParam("nameInput")String name,
                            @RequestParam("descriptionInput")String description,
                            @RequestParam("groupId") Long groupId) {

        Pastry pastryToAdd = new Pastry(name, description);
        pastryRepository.save(pastryToAdd);

        return "redirect:home";
    }*/
    @PostMapping("/add")
    public String addPastryFormSubmission(Pastry pastry) {
        pastryRepository.save(pastry);
        return "redirect:/home";
    }
}
