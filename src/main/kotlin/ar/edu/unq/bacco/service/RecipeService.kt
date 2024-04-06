package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.repository.RecipeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RecipeService(private val recipeRepository : RecipeRepository) {

    fun filterRecipesByBeverages(beverageNames: List<String>): List<Recipe> {
        val listCaps = beverageNames.map { str -> str.uppercase(Locale.getDefault()) }
        val recipes = recipeRepository.findRecipesByBeverageNames(listCaps).toList()
        return recipes
    }
}


