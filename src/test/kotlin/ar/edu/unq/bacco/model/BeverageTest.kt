package ar.edu.unq.bacco.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BeverageTest {
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
}