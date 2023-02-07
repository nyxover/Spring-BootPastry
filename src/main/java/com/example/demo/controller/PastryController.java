package com.example.demo.controller;

import com.example.demo.repository.entity.Pastry;
import com.example.demo.service.IngredientService;
import com.example.demo.service.PastryService;
import com.example.demo.service.dto.IngredientDto;
import com.example.demo.service.dto.PastryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pastries")
public class PastryController {
    @Autowired
    private PastryService pastryService;
    @Autowired
    private IngredientService ingredientService;
    @GetMapping("/all")
    public String displayAllPastries(Model model) {
        List<PastryDto> pastryList = pastryService.fetchPastries();
        model.addAttribute("pastries", pastryList);
        return "home.html";
    }

    @GetMapping("/{id}")
    public  String displaySpecificPastry(@PathVariable Long id, Model model){
        Optional<PastryDto> pastryOptional = pastryService.fetchById(id);
        if (pastryOptional.isPresent()){
            model.addAttribute("pastry", pastryOptional.get());
            return "pastry-details.html";
        } else {
            return "404.html";
        }
    }
    @GetMapping ("/add")
    public String displayAddPastryForm(Model model) {
    Pastry pastry = new Pastry();
    model.addAttribute("pastry", pastry);
    List<IngredientDto> ingredients = ingredientService.fetchIngredients();
    model.addAttribute("ingredients", ingredients);
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
        pastryService.addPastry(pastry);
        return "redirect:/pastries/all";
    }
}
