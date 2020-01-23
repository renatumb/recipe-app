package com.rbonfim.recipeapp.repositories;

import com.rbonfim.recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
