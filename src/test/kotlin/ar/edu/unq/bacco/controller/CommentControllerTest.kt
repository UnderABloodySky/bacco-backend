package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Comment
import ar.edu.unq.bacco.model.DTO.CommentDTO
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.CommentService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@ExtendWith(MockitoExtension::class)
class CommentControllerTest {
/*
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Mock
    private lateinit var commentService: CommentService

    @InjectMocks
    private lateinit var commentController: CommentController

    @Test
    fun `addComment should return CREATED when comment is successfully added`() {
        val commentDTO = CommentDTO(
            content = "Great recipe!",
            userId = 1L,
            recipeId = 1L
        )

        val user = User(id = 1L, name = "John Doe", email="", password="") // Assuming User class has at least these fields
        val comment = Comment(
            id = 1L,
            content = "Great recipe!",
            user = user
        )

        Mockito.`when`(commentService.addComment(commentDTO)).thenReturn(comment)

        mockMvc.perform(post("/comments")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                    "content": "Great recipe!",
                    "userId": 1,
                    "recipeId": 1
                }
            """.trimIndent()))
            .andExpect(status().isCreated)
            .andExpect(content().json("""
                {
                    "id": 1,
                    "content": "Great recipe!",
                    "user": {
                        "id": 1,
                        "name": "John Doe"
                    }
                }
            """.trimIndent()))
    }*/
}

