package ar.edu.unq.bacco.model.DTO

data class RecipeDTO(
    val name: String,
    val description: String,
    val beverages: List<String>,
    val ingredients: List<String>,
)