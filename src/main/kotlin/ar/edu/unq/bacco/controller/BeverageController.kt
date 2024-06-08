package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.service.BeverageService
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntityBuilder
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.entity.mime.content.StringBody
import org.apache.http.impl.client.HttpClients
import org.springframework.beans.factory.annotation.Autowired
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
class BeverageController(
    private val beverageService: BeverageService,
    @Value("\${django.backend.url.retrain}") private var djangoRetrainUrl: String = "http://localhost:8000/upload-photo-for-retrain",
) {
    @GetMapping("/search")
    fun getBeveragesByName(@RequestParam name: String): List<Beverage> {
        return beverageService.findBeveragesByName(name)
    }

    @PostMapping("/retrain")
    fun sendPhotoForRetrain(@RequestParam("file") file: MultipartFile,
                            @RequestParam("beverage") beverage: String): ResponseEntity<String> {
        return if (file.isEmpty) {
            ResponseEntity("Por favor, selecciona un archivo", HttpStatus.BAD_REQUEST)
        } else {
            try {
                val fileName = "${System.currentTimeMillis()}_${file.originalFilename}"
                val uploadDir = File("retrain")
                uploadDir.mkdir()
                val filePath = Paths.get(uploadDir.absolutePath, fileName)
                Files.copy(file.inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)

                // Preparar la solicitud HTTP para enviar la imagen al backend Django
                val httpClient = HttpClients.createDefault()
                val postRequest = HttpPost(djangoRetrainUrl)

                // Construir el cuerpo de la solicitud con la imagen
                val fileBody = FileBody(File(filePath.toString()), ContentType.DEFAULT_BINARY)
                val beverageBodyPart = StringBody(beverage, ContentType.TEXT_PLAIN)
                val reqEntity: HttpEntity = MultipartEntityBuilder.create()
                    .addPart("photo", fileBody)
                    .addPart("beverage", beverageBodyPart)
                    .build()
                postRequest.entity = reqEntity

                // Enviar la solicitud al backend Django
                val response: HttpResponse = httpClient.execute(postRequest)
                val responseEntity = response.entity
                val responseString = responseEntity.content.bufferedReader().use { it.readText() }


                // Manejar la respuesta del backend Django
                return if (response.statusLine.statusCode == HttpStatus.OK.value()) {
                    ResponseEntity(responseString, HttpStatus.OK)
                } else {
                    ResponseEntity(responseString, HttpStatus.INTERNAL_SERVER_ERROR)
                }
            } catch (e: Exception) {
                return ResponseEntity("Error al enviar la foto para reentrenamiento: ${e.message}", HttpStatus.INTERNAL_SERVER_ERROR)
            }
        }
    }


}