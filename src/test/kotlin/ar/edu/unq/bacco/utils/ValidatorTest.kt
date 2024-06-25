package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.User
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidatorTest {
/*
    private val validator = Validator()

    @Test
    fun testValidatorReturnTrueWhenRecipeDTOIsValid(){
        val recipeDTO = RecipeDTO("asd", "asdfg", listOf("ron"), listOf("hielo"))
        assertTrue(validator.isValidateRecipeDTO(recipeDTO))
    }

    @Test
    fun testValidatorReturnFalseWhenRecipeDTOIsNotValidWithoutName(){
        val recipeDTO = RecipeDTO("", "asdfg", listOf("ron"), listOf("hielo"))
        assertFalse(validator.isValidateRecipeDTO(recipeDTO))
    }

    @Test
    fun testValidatorReturnFalseWhenRecipeDTOIsNotValidWithoutDescription(){
        val recipeDTO = RecipeDTO("asd", "", listOf("ron"), listOf("hielo"))
        assertFalse(validator.isValidateRecipeDTO(recipeDTO))
    }

    @Test
    fun testValidatorReturnFalseWhenRecipeDTOIsNotValidWithoutBeverageName(){
        val recipeDTO = RecipeDTO("asd", "asdfg", listOf(""), listOf("hielo"))
        assertFalse(validator.isValidateRecipeDTO(recipeDTO))
    }

    @Test
    fun testValidatorReturnFalseWhenRecipeDTOIsNotValidWithoutIngredientName(){
        val recipeDTO = RecipeDTO("asd", "asdfg", listOf("ron"), listOf(""))
        assertFalse(validator.isValidateRecipeDTO(recipeDTO))
    }

    @Test
    fun testValidatorReturnFalseWhenRecipeDTOIsNotValidWithAllIncorrectAtributes(){
        val recipeDTO = RecipeDTO("", "", listOf(""), listOf(""))
        assertFalse(validator.isValidateRecipeDTO(recipeDTO))
    }

    @Test
    fun anUserIsValid(){
        val user = User(name="hola", email="asd@gmail.com", password = "12345678")
        assertTrue(validator.isValidadateUser(user))
    }

    @Test
    fun anUserIsInvalidWithoutName(){
        val user = User(name="", email="asd@gmail.com", password = "12345678")
        assertFalse(validator.isValidadateUser(user))
    }

    @Test
    fun anUserIsInvalidWithoutEmail(){
        val user = User(name="hola", email="", password = "12345678")
        assertFalse(validator.isValidadateUser(user))
    }

    @Test
    fun anUserIsInvalidWithoutValidEmail(){
        val user = User(name="hola", email="cualquiercosamenosunmail", password = "12345678")
        assertFalse(validator.isValidadateUser(user))
    }

    @Test
    fun anUserIsInvalidWithoutPassword(){
        val user = User(name="hola", email="asd@gmail.com", password = "")
        assertFalse(validator.isValidadateUser(user))
    }


    @Test
    fun anUserIsInvalidWithoutAnyAtr(){
        val user = User(name="", email="", password = "")
        assertFalse(validator.isValidadateUser(user))
    }*/
}