package com.example.repository;

import com.example.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe , Long> {
//    public Optional<Recipe> findById(Long recipeId);
}
