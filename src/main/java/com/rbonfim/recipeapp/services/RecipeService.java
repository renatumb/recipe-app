package com.rbonfim.recipeapp.services;

import com.rbonfim.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
