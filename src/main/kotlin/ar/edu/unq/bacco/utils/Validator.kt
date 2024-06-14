package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.DTO.RecipeDTO
import org.springframework.stereotype.Component

@Component
class Validator {
    fun isValidateRecipeDTO(aRecipeDTO: RecipeDTO): Boolean{
        return aRecipeDTO.name != "" && aRecipeDTO.description != "" && aRecipeDTO.beverages.isNotEmpty() && aRecipeDTO.ingredients.isNotEmpty()
    }
}