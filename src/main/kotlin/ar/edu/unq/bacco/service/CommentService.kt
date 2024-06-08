package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Comment
import ar.edu.unq.bacco.model.DTO.CommentDTO
import ar.edu.unq.bacco.repository.CommentRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommentService(
    private val commentRepository: CommentRepository,
    private val userRepository: UserRepository,
    private val recipeRepository: RecipeRepository
) {
    fun addComment(commentDTO: CommentDTO): Comment? {
        val user = userRepository.findById(commentDTO.userId).orElseThrow { RuntimeException("User not found") }
        val recipe = recipeRepository.findById(commentDTO.recipeId).orElseThrow { RuntimeException("Recipe not found") }

        val comment = Comment(content = commentDTO.content, user = user, recipe = recipe)
        recipe.comments.add(comment)
        recipeRepository.save(recipe)
        return commentRepository.save(comment)
    }
}
