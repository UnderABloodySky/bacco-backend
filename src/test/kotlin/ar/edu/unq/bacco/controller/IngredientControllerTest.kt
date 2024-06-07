package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Ingredient
import ar.edu.unq.bacco.service.IngredientService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.web.bind.annotation.RequestParam

class IngredientControllerTest {

    @Mock
    lateinit var ingredientService: IngredientService

    @InjectMocks
    lateinit var ingredientController: IngredientController

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `test getBeveragesByName should return list of ingredients with matching name`() {
        val expectedIngredients = listOf(
            Ingredient(id = 1, name = "Ingredient 1"),
            Ingredient(id = 2, name = "Ingredient 2")
        )
        val searchName = "Ingredient"

        `when`(ingredientService.findIngredientsByName(searchName)).thenReturn(expectedIngredients)

        val result = ingredientController.getBeveragesByName(searchName)

        assertEquals(expectedIngredients, result)
    }

    @Test
    fun `test getBeveragesByName should return empty list when no ingredients found`() {
        val searchName = "NonExistentIngredient"

        `when`(ingredientService.findIngredientsByName(searchName)).thenReturn(emptyList())

        val result = ingredientController.getBeveragesByName(searchName)

        assertEquals(emptyList<Ingredient>(), result)
    }
}
