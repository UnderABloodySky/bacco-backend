package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.utils.Mediator
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@RestController
@RequestMapping("/imgs")
class RecipeController(private val recipeService: RecipeService) {

    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        if (file.isEmpty) {
            return ResponseEntity("Por favor, selecciona un archivo", HttpStatus.BAD_REQUEST)
        }

        return try {
            val fileName = "${System.currentTimeMillis()}_${file.originalFilename}"
            val uploadDir = File("uploads")
            uploadDir.mkdir()
            Files.copy(file.inputStream, Paths.get(uploadDir.absolutePath, fileName), StandardCopyOption.REPLACE_EXISTING)
            val filePath = "D:/UNQUI/TIP/bacco-backend/uploads/$fileName"
            val beverage = Mediator().detectBeverage(filePath)
            ResponseEntity(beverage, HttpStatus.OK)
        } catch (e: Exception) {
            ResponseEntity("Error al cargar el archivo", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    @GetMapping("/recipes")
    fun filterRecipesByBeverages(@RequestBody beverageNames: List<String>): List<Recipe> {
        return recipeService.filterRecipesByBeverages(beverageNames)
    }
}