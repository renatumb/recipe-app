package com.rbonfim.recipeapp.services;

import com.rbonfim.recipeapp.domain.Recipe;
import com.rbonfim.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(this.recipeRepository);
    }

    @Test
    public void getRecipes() {

        HashSet<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        when(recipeRepository.findAll()).thenReturn(recipes);

        recipeRepository.findAll();

        assertEquals(recipes.size(), 1);

        verify(recipeRepository, times(1)).findAll();
    }
}