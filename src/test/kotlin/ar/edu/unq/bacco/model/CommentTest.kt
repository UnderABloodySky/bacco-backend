package ar.edu.unq.bacco.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CommentTest {

    @Test
    fun createCommentWithNonNullId() {
        val content = "Great recipe!"
        val user = User(id = 1L, name = "Alice")

        val comment = Comment(content = content, user = user)

        assertThat(comment.content).isEqualTo(content)
        assertThat(comment.user).isEqualTo(user)
        assertThat(comment.id).isEqualTo(null)
    }

    @Test
    fun createCommentWithNullId() {
        val content = "Fantastic!"
        val user = User(id = 2L, name = "Bob")

        val comment = Comment(content = content, user = user, id = null)

        assertThat(comment.content).isEqualTo(content)
        assertThat(comment.user).isEqualTo(user)
        assertThat(comment.id).isNull()
    }

    @Test
    fun createCommentWithNullUser() {
        val content = "Nice!"

        assertThrows<NullPointerException> {
            Comment(content = content, user = null!!)
        }
    }
}