package ar.edu.unq.bacco.model.DTO

data class RecipeDTO(
    val name: String,
    val beverages: List<BeverageDTO>
)