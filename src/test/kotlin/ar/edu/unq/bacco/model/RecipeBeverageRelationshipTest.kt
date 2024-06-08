package ar.edu.unq.bacco.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class RecipeBeverageRelationshipTest {

    @Test
    fun createRecipeBeverageRelationshipWithNonNullId() {
        val beverage = Beverage(id = 1L, name = "Cola")
        val measure = 250
        val relationship = RecipeBeverageRelationship(beverage = beverage, measure = measure)

        assertThat(relationship.id).isNull()
        assertThat(relationship.beverage).isEqualTo(beverage)
        assertThat(relationship.measure).isEqualTo(measure)
    }

    @Test
    fun createRecipeBeverageRelationshipWithNullId() {
        val beverage = Beverage(id = 2L, name = "Orange Juice")
        val relationship = RecipeBeverageRelationship(beverage = beverage)

        assertThat(relationship.id).isNull()
        assertThat(relationship.beverage).isEqualTo(beverage)
        assertThat(relationship.measure).isEqualTo(1)
    }

    @Test
    fun updateMeasure() {
        val beverage = Beverage(id = 3L, name = "Water")
        val relationship = RecipeBeverageRelationship(beverage = beverage, measure = 500)

        val newMeasure = 750
        relationship.measure = newMeasure

        assertThat(relationship.measure).isEqualTo(newMeasure)
    }
}
