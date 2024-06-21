package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Rating
import ar.edu.unq.bacco.service.RatingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ratings")
class RatingController @Autowired constructor (private var ratingService: RatingService) {

    @PostMapping("/recipe/{recipeId}/user/{userId}")
    fun rateRecipe(
        @PathVariable recipeId: Long,
        @PathVariable userId: Long,
        @RequestParam score: Double
    ): ResponseEntity<Rating> {
        return ResponseEntity(ratingService.rateRecipe(recipeId, userId, score), HttpStatus.CREATED)
    }

    @GetMapping("/recipe/{recipeId}/average")
    fun getAverageRatingForRecipe(@PathVariable recipeId: Long): ResponseEntity<Double> {
        return ResponseEntity(ratingService.getAverageRatingForRecipe(recipeId), HttpStatus.OK)
    }
}