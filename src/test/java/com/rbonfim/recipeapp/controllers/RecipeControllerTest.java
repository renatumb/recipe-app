package com.rbonfim.recipeapp.controllers;

import com.rbonfim.recipeapp.domain.Recipe;
import com.rbonfim.recipeapp.repositories.RecipeRepository;
import com.rbonfim.recipeapp.services.RecipeService;
import com.rbonfim.recipeapp.services.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@ExtendWith(MockitoExtension.class)
class RecipeControllerTest {

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeController recipeController;

    RecipeService recipeService;
    MockMvc mockMvc;


    Long id;
    Recipe r;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);

        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        id = new Random().nextLong();
        r = new Recipe();
        r.setId(id);
    }

    @Test
    void showById() throws Exception {

        //when( recipeService.findById( anyLong() ) ).thenReturn( r);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("recipe/show/1"));


    }
}