package ar.edu.unq.bacco.model.DTO

data class CommentDTO(
    val content: String,
    val userId: Long,
    val recipeId: Long
)