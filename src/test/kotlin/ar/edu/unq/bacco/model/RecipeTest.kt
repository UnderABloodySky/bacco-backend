    package ar.edu.unq.bacco.model

    import org.assertj.core.api.Assertions.assertThat
    import org.junit.jupiter.api.Assertions.assertEquals
    import org.junit.jupiter.api.Assertions.assertTrue
    import org.junit.jupiter.api.Test
    import org.junit.jupiter.api.assertThrows

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

        @Test
        fun createRecipeWithNonNullId() {
            val user = User(id = 1L, name = "Alice")
            val name = "Lasagna"
            val description = "Delicious homemade lasagna recipe"
            val imagePath = "https://example.com/lasagna.jpg"
            val recipe = Recipe(id = 1L, name = name, description = description, user = user, imagePath = imagePath)

            assertThat(recipe.id).isEqualTo(1L)
            assertThat(recipe.name).isEqualTo(name)
            assertThat(recipe.description).isEqualTo(description)
            assertThat(recipe.user).isEqualTo(user)
            assertThat(recipe.imagePath).isEqualTo(imagePath)
        }

        @Test
        fun createRecipeWithNullId() {
            val user = User(id = 2L, name = "Bob")
            val name = "Pizza"
            val description = "Homemade pizza recipe"
            val recipe = Recipe(name = name, description = description, user = user)

            assertThat(recipe.id).isNull()
            assertThat(recipe.name).isEqualTo(name)
            assertThat(recipe.description).isEqualTo(description)
            assertThat(recipe.user).isEqualTo(user)
            assertThat(recipe.imagePath).isEqualTo("https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/no_image.png")
        }

        @Test
        fun rateRecipe() {
            val user = User(id = 3L, name = "Charlie")
            val recipe = Recipe(name = "Pasta", description = "Spaghetti recipe")
            val score = 4

            val rating = recipe.rate(user, score)

            assertThat(rating.user).isEqualTo(user)
            assertThat(rating.score).isEqualTo(score)
            assertThat(recipe.ratings).contains(rating)
        }

        @Test
        fun rateRecipeWithInvalidScore() {
            val user = User(id = 4L, name = "David")
            val recipe = Recipe(name = "Salad", description = "Caesar salad recipe")

            assertThrows<IllegalArgumentException> {
                recipe.rate(user, score = -1)
            }

            assertThrows<IllegalArgumentException> {
                recipe.rate(user, score = 6)
            }
        }

        @Test
        fun updateExistingRating() {
            val user = User(id = 5L, name = "Emily")
            val recipe = Recipe(name = "Soup", description = "Vegetable soup recipe")
            recipe.rate(user, score = 3)

            val newScore = 5
            val rating = recipe.rate(user, newScore)

            assertThat(rating.user).isEqualTo(user)
            assertThat(rating.score).isEqualTo(newScore)
            assertThat(recipe.ratings.size).isEqualTo(1)
        }

        @Test
        fun averageRatingWithoutRatings() {
            val recipe = Recipe(name = "Burger", description = "Classic burger recipe")

            assertThat(recipe.averageRating()).isEqualTo(0.0)
        }

        @Test
        fun averageRatingWithRatings() {
            val user1 = User(id = 6L, name = "Frank")
            val user2 = User(id = 7L, name = "Grace")
            val recipe = Recipe(name = "Cake", description = "Chocolate cake recipe")
            recipe.rate(user1, score = 4)
            recipe.rate(user2, score = 5)

            assertThat(recipe.averageRating()).isEqualTo(4.5)
        }
    }