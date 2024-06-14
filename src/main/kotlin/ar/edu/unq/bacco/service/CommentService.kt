package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Comment
import ar.edu.unq.bacco.model.DTO.CommentDTO
import ar.edu.unq.bacco.repository.CommentRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService @Autowired constructor(
    private var commentRepository: CommentRepository,
    private var userRepository: UserRepository,
    private var recipeRepository: RecipeRepository) {

    fun addComment(commentDTO: CommentDTO): Comment? {
        val user = userRepository.findById(commentDTO.userId).orElseThrow { RuntimeException("User not found") }
        val recipe = recipeRepository.findById(commentDTO.recipeId).orElseThrow { RuntimeException("Recipe not found") }

        val comment = Comment(content = commentDTO.content, user = user)
        recipe.comments.add(comment)
        recipeRepository.save(recipe)
        return commentRepository.save(comment)
    }
}
