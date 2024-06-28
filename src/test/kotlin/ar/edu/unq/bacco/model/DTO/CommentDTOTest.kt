package ar.edu.unq.bacco.model.DTO

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class CommentDTOTest {
    @Test
    fun `create CommentDTO with valid parameters`() {
        val content = "This is a comment"
        val userId = 123L
        val recipeId = 456L

        val commentDTO = CommentDTO(content, userId, recipeId)

        assertThat(commentDTO.content).isEqualTo(content)
        assertThat(commentDTO.userId).isEqualTo(userId)
        assertThat(commentDTO.recipeId).isEqualTo(recipeId)
    }

    @Test
    fun `create CommentDTO with null content`() {
        val content: String? = null
        val userId = 123L
        val recipeId = 456L

        assertThrows<NullPointerException> {
            CommentDTO(content!!, userId, recipeId)
        }
    }
}
