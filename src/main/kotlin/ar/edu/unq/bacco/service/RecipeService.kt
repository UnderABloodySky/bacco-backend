package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.repository.BeverageRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeService(private val recipeRepository : RecipeRepository) {
    fun findRecipesByBeverage(aBeverageName: String): List<Recipe> {
        return recipeRepository.findByBeverageName(aBeverageName).toList()
    }

    fun filterRecipesByBeverages(beverageNames: List<String>): List<Recipe> {
        return recipeRepository.findRecipesByBeverageNames(beverageNames).toList()
    }
}

