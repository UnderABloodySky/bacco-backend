package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.service.BeverageService
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntity
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.impl.client.HttpClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@RestController
@RequestMapping("/beverages")
class BeverageController(private val beverageService: BeverageService) {

    @Value("\${django.backend.url.retrain}")
    private lateinit var djangoRetrainUrl: String

    @GetMapping("/search")
    fun getBeveragesByName(@RequestParam name: String): List<Beverage> {
        return beverageService.findBeveragesByName(name)
    }

    @PostMapping("/retrain")
    fun sendPhotoForRetrain(@RequestParam("file") file: MultipartFile,
                            @RequestParam("beverage") beverage: String): ResponseEntity<String> {
        if (file.isEmpty) {
            return ResponseEntity("Por favor, selecciona un archivo", HttpStatus.BAD_REQUEST)
        }
        return try {
            val fileName = "${System.currentTimeMillis()}_${file.originalFilename}"
            val uploadDir = File("retrain")
            uploadDir.mkdir()
            Files.copy(file.inputStream, Paths.get(uploadDir.absolutePath, fileName), StandardCopyOption.REPLACE_EXISTING)
            val filePath = "D:/UNQUI/TIP/bacco-backend/retrain/$fileName"

            // Preparar la solicitud HTTP para enviar la imagen al backend Django
            val httpClient = HttpClients.createDefault()
            val postRequest = HttpPost(djangoRetrainUrl)

            // Construir el cuerpo de la solicitud con la imagen
            val fileBody = FileBody(File(filePath), ContentType.DEFAULT_BINARY)
            val reqEntity: HttpEntity = MultipartEntityBuilder.create()
                .addPart("photo", fileBody)
                .addPart("beverage", fileBody)
                .build()
            postRequest.entity = reqEntity

            // Enviar la solicitud al backend Django
            val response: HttpResponse = httpClient.execute(postRequest)

            return ResponseEntity(response.toString(), HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity("Error al enviar la foto para reentrenamiento: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


}