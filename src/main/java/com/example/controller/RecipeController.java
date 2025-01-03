package com.example.controller;

import com.example.model.Recipe;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.RecipeService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping("/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe , @PathVariable Long userId) throws Exception {

        User user = userService.findUserById(userId);
        recipe.setUser(user);
        Recipe createdRecipe = recipeService.createRecipe(recipe , user);
        return createdRecipe;

    }

//    @GetMapping("/api/recipe/{id}")
//    public Recipe findRecipeById(@PathVariable Recipe recipe) throws Exception{
//
//    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe , @PathVariable Long id) throws Exception {

        Recipe updatedRecipe = recipeService.updateRecipe(recipe , id);
        return updatedRecipe;
    }

    @GetMapping()
            public List<Recipe> getAllRecipe() throws Exception {

            List<Recipe> recipes = recipeService.findAllRecipe();
             return recipes;

    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "recipe deleted!";

    }

    @PutMapping("/{recipeId}/like/user/{userId}")
    public Recipe LikeRecipe(@PathVariable Long recipeId , @PathVariable Long userId) throws Exception {

        User user = userService.findUserById(userId);

        Recipe updatedRecipe = recipeService.LikeRecipe( recipeId , user);
        return updatedRecipe;
    }


}
