package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.repository.BeverageRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(private val recipeRepository : RecipeRepository, private val beverageRepository : BeverageRepository) {

    fun filterRecipesByBeverages(beverageNames: List<String>): List<Recipe> {
        return recipeRepository.findRecipesByBeverageNames(beverageNames).toList()
    }
}

