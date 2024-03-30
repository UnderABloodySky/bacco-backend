package ar.edu.unq.bacco.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
@RequestMapping("/imgs")
class ImageController {

    @PostMapping("/upload")
    fun uploadImage(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
        if (file.isEmpty) {
            return ResponseEntity("Por favor, selecciona un archivo", HttpStatus.BAD_REQUEST)
        }

        try {
            val fileName = "${System.currentTimeMillis()}_${file.originalFilename}"
            val uploadDir = File("uploads")
            uploadDir.mkdir()
            Files.copy(file.inputStream, Paths.get(uploadDir.absolutePath, fileName), StandardCopyOption.REPLACE_EXISTING)
            val filePath = "/uploads/$fileName"
            // TODO: consume external API to analyze image and get the beverage name
            return ResponseEntity("Fernet", HttpStatus.OK)
        } catch (e: Exception) {
            return ResponseEntity("Error al cargar el archivo", HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}