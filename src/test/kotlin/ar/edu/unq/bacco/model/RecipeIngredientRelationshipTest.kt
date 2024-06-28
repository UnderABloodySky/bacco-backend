package ar.edu.unq.bacco.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RecipeIngredientRelationshipTest {
    @Test
    fun createRecipeIngredientRelationshipWithNonNullId() {
        val ingredient = Ingredient(id = 1L, name = "Flour")
        val quantity = 2
        val relationship = RecipeIngredientRelationship(ingredient = ingredient, quantity = quantity)

        assertThat(relationship.id).isNull()
        assertThat(relationship.ingredient).isEqualTo(ingredient)
        assertThat(relationship.quantity).isEqualTo(quantity)
    }

    @Test
    fun createRecipeIngredientRelationshipWithNullId() {
        val ingredient = Ingredient(id = 2L, name = "Sugar")
        val relationship = RecipeIngredientRelationship(ingredient = ingredient)

        assertThat(relationship.id).isNull()
        assertThat(relationship.ingredient).isEqualTo(ingredient)
        assertThat(relationship.quantity).isEqualTo(1)
    }

    @Test
    fun updateQuantity() {
        val ingredient = Ingredient(id = 3L, name = "Salt")
        val relationship = RecipeIngredientRelationship(ingredient = ingredient, quantity = 3)

        val newQuantity = 5
        relationship.quantity = newQuantity

        assertThat(relationship.quantity).isEqualTo(newQuantity)
    }
}
