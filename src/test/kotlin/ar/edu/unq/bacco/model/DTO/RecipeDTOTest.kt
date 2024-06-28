package ar.edu.unq.bacco.model.DTO

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RecipeDTOTest {

    @Test
    fun `create RecipeDTO with valid parameters`() {
        val name = "Chocolate Cake"
        val description = "A delicious chocolate cake recipe"
        val beverages = listOf("Coffee", "Milk")
        val ingredients = listOf("Flour", "Sugar", "Cocoa Powder")

        val recipeDTO = RecipeDTO(name, description, beverages, ingredients)

        assertThat(recipeDTO.name).isEqualTo(name)
        assertThat(recipeDTO.description).isEqualTo(description)
        assertThat(recipeDTO.beverages).containsExactlyElementsOf(beverages)
        assertThat(recipeDTO.ingredients).containsExactlyElementsOf(ingredients)
    }

    @Test
    fun `create RecipeDTO with null name`() {
        val name: String? = null
        val description = "A delicious chocolate cake recipe"
        val beverages = listOf("Coffee", "Milk")
        val ingredients = listOf("Flour", "Sugar", "Cocoa Powder")

        assertThrows<NullPointerException> {
            RecipeDTO(name!!, description, beverages, ingredients)
        }
    }

}