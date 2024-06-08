package ar.edu.unq.bacco.controller


import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.utils.MediatorBaccoCNN
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

@RestController
@RequestMapping("/imgs")
class RecipeController(private val recipeService: RecipeService) {

    //@Value("\${django.backend.url}")
    //private lateinit var djangoBackendUrl: String

    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        if (file.isEmpty) {
            return ResponseEntity("Por favor, selecciona un archivo", HttpStatus.BAD_REQUEST)
        }
        return try {
            MediatorBaccoCNN().detectBeverage(file)
        }
        catch (e: IOException) {
                ResponseEntity("Error al cargar el archivo", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    @GetMapping("/recipes")
    fun filterRecipes(
        @RequestParam(required = false, defaultValue = "") beverageNames: List<String>?,
        @RequestParam(required = false, defaultValue = "") ingredientNames: List<String>?
    ): List<Recipe> {
        return recipeService.filterRecipesByBeveragesOrIngredients(beverageNames.orEmpty(), ingredientNames.orEmpty())
    }

    @GetMapping("/recipe/{id}")
    fun getRecipe(@PathVariable id: Long): ResponseEntity<Recipe> {
        return ResponseEntity(recipeService.getRecipeById(id), HttpStatus.OK)
    }


    @PostMapping("/recipe")
    fun createRecipe(@RequestBody aRecipeDTO: RecipeDTO): ResponseEntity<Any> {
        try{
            val savedRecipe = recipeService.save(aRecipeDTO)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe)
        }
        catch(e: Exception){
            return ResponseEntity("Campos incorrectos", HttpStatus.BAD_REQUEST)
        }

    }
}