package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.*
import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.repository.BeverageRepository
import ar.edu.unq.bacco.repository.IngredientRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RecipeService(private val recipeRepository : RecipeRepository, private val ingredientRepository: IngredientRepository, private val beverageRepository: BeverageRepository) {

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

    fun save(aRecipeDTO: RecipeDTO, user: User? = null): Recipe?{
        val name = aRecipeDTO.name
        val description = aRecipeDTO.description
        val ingredients = aRecipeDTO.ingredients.stream().map { str -> ingredientRepository.findByNameContainingIgnoreCase(str)}.toList()
        val beverages = aRecipeDTO.beverages.stream().map { str -> beverageRepository.findByNameContainingIgnoreCase(str)}.toList()

        val newRecipe = Recipe(name = name, description = description)
        if(user != null){
            newRecipe.user = user
        }
        val ingredientsRelationships = ingredients.stream().map{ ing -> RecipeIngredientRelationship(ingredient = ing.get(0))}.toList()
        val beveragesRelationships =  beverages.stream().map{ bev -> RecipeBeverageRelationship(beverage = bev.get(0))}.toList()
        newRecipe.beverages.addAll(beveragesRelationships)
        newRecipe.ingredients.addAll(ingredientsRelationships)

        return  recipeRepository.save(newRecipe)
    }

    fun getRecipeById(id: Long): Recipe? {
        return recipeRepository.findById(id).get()
    }
}


