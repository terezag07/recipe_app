package com.example.service;

import com.example.model.Recipe;
import com.example.model.User;

import java.util.List;

public interface RecipeService {

    public Recipe createRecipe(Recipe recipe , User user);

    public Recipe findRecipeById(Long id) throws Exception;

    public void deleteRecipe(Long id) throws Exception;

    public Recipe updateRecipe(Recipe recipe , Long Id) throws Exception;

    public List<Recipe> findAllRecipe();

    public Recipe LikeRecipe(Long recipeId, User user) throws Exception;


}
