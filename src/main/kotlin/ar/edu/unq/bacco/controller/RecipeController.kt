package ar.edu.unq.bacco.controller


import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.service.RecipeService
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntity
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.impl.client.HttpClients
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
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
            //val beverage = Mediator().detectBeverage(filePath)


            // Preparar la solicitud HTTP para enviar la imagen al backend Django
            val httpClient = HttpClients.createDefault()
            val postRequest = HttpPost("http://localhost:8000/upload-photo")

            // Construir el cuerpo de la solicitud con la imagen
            val fileBody = FileBody(File(filePath), ContentType.DEFAULT_BINARY)
            val reqEntity: HttpEntity = MultipartEntity().apply {
                addPart("photo", fileBody)
            }
            postRequest.entity = reqEntity

            // Enviar la solicitud al backend Django
            val response: HttpResponse = httpClient.execute(postRequest)

            // Manejar la respuesta del backend Django
            if (response.statusLine.statusCode == HttpStatus.OK.value()) {
                ResponseEntity("Imagen cargada exitosamente en el backend Django", HttpStatus.OK)
            } else {
                ResponseEntity("Error al cargar la imagen en el backend Django", HttpStatus.INTERNAL_SERVER_ERROR)
            }
        } catch (e: IOException) {
            ResponseEntity("Error al cargar el archivo", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/recipes")
    fun filterRecipesByBeverages(@RequestParam beverageNames: List<String>): List<Recipe> {
        return recipeService.filterRecipesByBeverages(beverageNames)
    }
}