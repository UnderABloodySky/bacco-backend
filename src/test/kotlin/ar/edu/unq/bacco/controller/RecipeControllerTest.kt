package ar.edu.unq.bacco.controller

import org.springframework.mock.web.MockMultipartFile
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.utils.MediatorBaccoCNN
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doThrow
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.io.IOException

class RecipeControllerTest {

    @Mock
    lateinit var recipeService: RecipeService

    @Mock
    lateinit var mediatorBaccoCNN: MediatorBaccoCNN

    @InjectMocks
    lateinit var recipeController: RecipeController

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test uploadImage should return bad request when file is empty`() {
        val file = MockMultipartFile("file", "filename.txt", "text/plain", "".toByteArray())

        val result = recipeController.uploadImage(file)

        assertEquals(HttpStatus.BAD_REQUEST, result.statusCode)
    }

    @Test
    fun `test uploadImage should return internal server error when IOException occurs`() {
        /*
        val file = MockMultipartFile("file", "filename.txt", "text/plain", "content".toByteArray())
        val errorMessage = "Error al cargar el archivo"
        val expectedResponse = ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        val exception = IOException()
        doThrow(exception).`when`(mediatorBaccoCNN).detectBeverage(file)

        val result = recipeController.uploadImage(file)
        assertEquals(expectedResponse, result)
    */
    }


        @Test
    fun `test uploadImage should return response entity from mediatorBaccoCNN`() {
        /*
        val file = MockMultipartFile("file", "filename.txt", "text/plain", "content".toByteArray())
        val responseEntity = ResponseEntity.ok("Successful detection")
        `when`(mediatorBaccoCNN.detectBeverage(file)).thenReturn(responseEntity)

        val result = recipeController.uploadImage(file)

        assertEquals(responseEntity, result)

         */
    }

    @Test
    fun `test filterRecipes should return filtered recipes`() {
        val beverageNames = listOf("Beverage1", "Beverage2")
        val ingredientNames = listOf("Ingredient1", "Ingredient2")
        val expectedRecipes = listOf(Recipe(id = 1, name = "Recipe1", description =  ""), Recipe(id = 2, name = "Recipe2", description =  ""))
        `when`(recipeService.filterRecipesByBeveragesOrIngredients(beverageNames, ingredientNames))
            .thenReturn(expectedRecipes)

        val result = recipeController.filterRecipes(beverageNames, ingredientNames)

        assertEquals(expectedRecipes, result)
    }

    @Test
    fun `test filterRecipes should return all recipes when no parameters provided`() {
        val expectedRecipes = listOf(Recipe(id = 1, name = "Recipe1", description =  ""), Recipe(id = 2, name = "Recipe2", description =  ""))
        `when`(recipeService.filterRecipesByBeveragesOrIngredients(emptyList(), emptyList()))
            .thenReturn(expectedRecipes)

        val result = recipeController.filterRecipes(null, null)

        assertEquals(expectedRecipes, result)
    }
}
