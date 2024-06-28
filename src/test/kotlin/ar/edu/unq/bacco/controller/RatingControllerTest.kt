package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Rating
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RatingService
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(RatingController::class)
class RatingControllerTest {


        @Autowired
        private lateinit var mockMvc: MockMvc

        @MockBean
        private lateinit var ratingService: RatingService

        //@Test
        fun `rateRecipe should return CREATED status and the rating`() {
            /*val recipeId = 1L
            val userId = 1L
            val score = 5.0
            val rating = Rating(user = User(name = "", email="", password=""), score = score)

            `when`(ratingService.rateRecipe(recipeId, userId, score)).thenReturn(rating)

            mockMvc.perform(
                MockMvcRequestBuilders.post("/ratings/recipe/$recipeId/user/$userId")
                    .param("score", score.toString())
                    .contentType(MediaType.APPLICATION_JSON)
            )
                .andExpect(MockMvcResultMatchers.status().isCreated)
                .andExpect(MockMvcResultMatchers.jsonPath("$.recipeId").value(recipeId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(userId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.score").value(score))
        */}

        //@Test
        fun `getAverageRatingForRecipe should return OK status and the average rating`() {
        /*
            val recipeId = 1L
            val averageRating = 4.5

            `when`(ratingService.getAverageRatingForRecipe(recipeId)).thenReturn(averageRating)

            mockMvc.perform(
                MockMvcRequestBuilders.get("/ratings/recipe/$recipeId/average")
                    .contentType(MediaType.APPLICATION_JSON)
            )
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string(averageRating.toString()))
        */}
}
