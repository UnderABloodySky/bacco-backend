package ar.edu.unq.bacco.utils

import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.mime.MultipartEntity
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.impl.client.HttpClients
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import org.springframework.http.ResponseEntity as ResponseEntity1

@Component
class MediatorBaccoCNN {
    @Value("\${django.backend.url}")
    private lateinit var djangoBackendUrl: String

    @Value("\${file.path.photos}")
    private lateinit var filePath: String


    fun detectBeverage(file: MultipartFile): ResponseEntity<String> {
        val fileName = "${System.currentTimeMillis()}_${file.originalFilename}"
        val uploadDir = File("uploads")
        uploadDir.mkdir()
        Files.copy(file.inputStream, Paths.get(uploadDir.absolutePath, fileName), StandardCopyOption.REPLACE_EXISTING)
        val definitiveFilePath = filePath+fileName
        //val filePath = "D:/UNQUI/TIP/bacco-backend/uploads/$fileName"

        // Preparar la solicitud HTTP para enviar la imagen al backend Django
        val httpClient = HttpClients.createDefault()
        val postRequest = HttpPost(djangoBackendUrl)

        // Construir el cuerpo de la solicitud con la imagen
        val fileBody = FileBody(File(definitiveFilePath), ContentType.DEFAULT_BINARY)
        val reqEntity: HttpEntity = MultipartEntity().apply {
            addPart("photo", fileBody)
        }
        postRequest.entity = reqEntity

        // Enviar la solicitud al backend Django
        val response: HttpResponse = httpClient.execute(postRequest)
        val responseEntity = response.entity
        val responseString = responseEntity.content.bufferedReader().use { it.readText() }

        // Manejar la respuesta del backend Django
        return if (response.statusLine.statusCode == HttpStatus.OK.value()) {
            ResponseEntity1(responseString, HttpStatus.OK)
        } else {
            ResponseEntity1(responseString, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}