package ar.edu.unq.bacco.service

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

    fun filterRecipesByIngredients(ingredientNames: List<String>): List<Recipe> {
        val listCaps = ingredientNames.map { str -> str.uppercase(Locale.getDefault()) }
        val recipes = recipeRepository.findRecipesByIngredientNames(listCaps).toList()
        return recipes
    }

    fun filterRecipesByBeveragesOrIngredients(
        beverageNames: List<String>,
        ingredientNames: List<String>
    ): List<Recipe> {
        val recipesByBeverages = if (beverageNames.isNotEmpty()) {
            filterRecipesByBeverages(beverageNames)
        } else {
            emptyList()
        }

        val recipesByIngredients = if (ingredientNames.isNotEmpty()) {
            filterRecipesByIngredients(ingredientNames)
        } else {
            emptyList()
        }

        val allRecipes = (recipesByBeverages + recipesByIngredients).distinctBy { it.id }
        return allRecipes
    }
}


