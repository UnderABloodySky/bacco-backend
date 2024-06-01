    package ar.edu.unq.bacco.model

    import org.junit.jupiter.api.Assertions.assertEquals
    import org.junit.jupiter.api.Assertions.assertTrue
    import org.junit.jupiter.api.Test

    class RecipeTest {

        @Test
        fun testConstructor() {
            val recipe = Recipe(name = "Mojito", description = "Refreshing cocktail")
            assertEquals("Mojito", recipe.name)
            assertEquals("Refreshing cocktail", recipe.description)
            assertEquals(null, recipe.id)
            assertTrue(recipe.beverages.isEmpty())
        }

        @Test
        fun testAddBeverage() {
            val recipe = Recipe(name = "Mojito", description = "Refreshing cocktail")
            val beverage = RecipeBeverageRelationship(Beverage(name = "Ron"))
            recipe.beverages.add(beverage)
            assertEquals(1, recipe.beverages.size)
            assertEquals(beverage, recipe.beverages.first())
        }
    }