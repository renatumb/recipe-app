package com.rbonfim.recipeapp.controllers;

import com.rbonfim.recipeapp.domain.Recipe;
import com.rbonfim.recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{idvar}")
    public String showById(@PathVariable String idvar, Model model) {


        Recipe recipe = recipeService.findById(Long.parseLong(idvar));

        model.addAttribute("recipe", recipe);

        return "recipe/viewRecipe";

    }
}
