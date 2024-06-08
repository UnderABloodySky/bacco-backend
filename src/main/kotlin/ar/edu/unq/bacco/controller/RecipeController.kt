package ar.edu.unq.bacco.controller


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

    @PostMapping
    fun createRecipe(@RequestBody anUser: User): ResponseEntity<User> {
        val savedUser = recipeService.save(anUser)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser)
    }
}