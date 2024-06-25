package ar.edu.unq.bacco.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BeverageTest {
    /*
    @Test
    fun testConstructor() {
        val beverage = Beverage(name = "Coffee")
        assertEquals("Coffee", beverage.name)
        assertEquals(null, beverage.id)
    }

    @Test
    fun testPropertyAccess() {
        val beverage = Beverage(name = "Coffee")
        assertEquals("Coffee", beverage.name)
    }

    @Test
    fun createBeverageWithValidParameters() {
        val name = "Coffee"
        val description = "A hot beverage made from brewed coffee beans"
        val imagePath = "https://example.com/coffee.jpg"

        val beverage = Beverage(name = name, description = description, imagePath = imagePath)

        assertThat(beverage.name).isEqualTo(name)
        assertThat(beverage.description).isEqualTo(description)
        assertThat(beverage.imagePath).isEqualTo(imagePath)
    }

    @Test
    fun createBeverageWithDefaultParameters() {
        val beverage = Beverage()

        assertThat(beverage.name).isEmpty()
        assertThat(beverage.description).isEmpty()
        assertThat(beverage.imagePath).isNull()
    }

    @Test
    fun createBeverageWithNullName() {
        val name: String? = null

        assertThrows<NullPointerException> {
            Beverage(name = name!!)
        }
    }

    @Test
    fun createBeverageWithNullImagePath() {
        val name = "Tea"
        val description = "A beverage made from steeping processed leaves, buds, or twigs of the Camellia sinensis plant in water."

        val beverage = Beverage(name = name, description = description, imagePath = null)

        assertThat(beverage.name).isEqualTo(name)
        assertThat(beverage.description).isEqualTo(description)
        assertThat(beverage.imagePath).isNull()
    }*/
}