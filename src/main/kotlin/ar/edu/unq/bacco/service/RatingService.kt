package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Rating
import ar.edu.unq.bacco.repository.RatingRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class RatingService(
    private val recipeRepository: RecipeRepository,
    private val userRepository: UserRepository,
    private val ratingRepository: RatingRepository
) {

    fun rateRecipe(recipeId: Long, userId: Long, score: Int): Rating {
        val recipe = recipeRepository.findById(recipeId)
            .orElseThrow { IllegalArgumentException("Recipe not found with id: $recipeId") }

        val user = userRepository.findById(userId)
            .orElseThrow { IllegalArgumentException("User not found with id: $userId") }

        if(score !in 0 ..5){
            throw IllegalArgumentException("Score must be between 0 and 5: $score")
        }

        val rating = recipe.rate(user, score)
        val ratingPerst = ratingRepository.save(rating)
        recipeRepository.save(recipe)
        return ratingPerst
    }

    fun getAverageRatingForRecipe(recipeId: Long): Double {
        val recipe = recipeRepository.findById(recipeId)
            .orElseThrow { IllegalArgumentException("Recipe not found with id: $recipeId") }

        return recipe.averageRating()
    }
}