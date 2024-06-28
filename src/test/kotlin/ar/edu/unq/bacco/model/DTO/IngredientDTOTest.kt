package ar.edu.unq.bacco.model.DTO

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class IngredientDTOTest {
    @Test
    fun `create IngredientDTO with valid name`() {
        // Arrange
        val name = "Sugar"

        // Act
        val ingredientDTO = IngredientDTO(name)

        // Assert
        assertThat(ingredientDTO.name).isEqualTo(name)
    }

    @Test
    fun `create IngredientDTO with null name`() {
        // Arrange
        val name: String? = null

        // Act & Assert
        assertThrows<NullPointerException> {
            IngredientDTO(name!!)
        }
    }
}