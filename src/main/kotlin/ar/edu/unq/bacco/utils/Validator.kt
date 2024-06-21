package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.User
import jakarta.validation.Validation
import jakarta.validation.ValidatorFactory
import org.springframework.stereotype.Component

@Component
class Validator {
    fun isValidateRecipeDTO(aRecipeDTO: RecipeDTO): Boolean{
        return aRecipeDTO.name != "" && aRecipeDTO.description != "" && aRecipeDTO.beverages.isNotEmpty() && aRecipeDTO.ingredients.isNotEmpty() && !aRecipeDTO.ingredients.contains("") && !aRecipeDTO.beverages.contains("")
    }

    fun isValidadateUser(anUser: User): Boolean{
        val validatorFactory = Validation.buildDefaultValidatorFactory()
        val validator = validatorFactory.validator
        val violations = validator.validate(anUser)
        return violations.isEmpty()
    }
}