package ar.edu.unq.bacco.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RatingTest {
    @Test
    fun createRatingWithNonNullId() {
        val user = User(id = 1L, name = "Alice", password = "", email="")
        val score = 4

        val rating = Rating(user = user, score = score)

        assertThat(rating.user).isEqualTo(user)
        assertThat(rating.score).isEqualTo(score)
        assertThat(rating.id).isEqualTo(null)
    }

    @Test
    fun createRatingWithNullId() {
        val user = User(id = 2L, name = "Bob", password = "", email="")
        val score = 5

        val rating = Rating(user = user, score = score, id = null)

        assertThat(rating.user).isEqualTo(user)
        assertThat(rating.score).isEqualTo(score)
        assertThat(rating.id).isNull()
    }

    @Test
    fun createRatingWithZeroScore() {
        val user = User(id = 3L, name = "Charlie", password = "", email="")
        val score = 0

        val rating = Rating(user = user, score = score)

        assertThat(rating.user).isEqualTo(user)
        assertThat(rating.score).isEqualTo(score)
        assertThat(rating.id).isNull()
    }

    @Test
    fun updateScore() {
        val user = User(id = 6L, name = "Frank", password = "", email="")
        val rating = Rating(user = user, score = 3)

        val newScore = 4
        rating.score = newScore

        assertThat(rating.score).isEqualTo(newScore)
    }
}