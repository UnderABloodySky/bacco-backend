import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.vision.v1.AnnotateImageRequest
import com.google.cloud.vision.v1.Feature
import com.google.cloud.vision.v1.Image
import com.google.cloud.vision.v1.ImageAnnotatorClient
import com.google.cloud.vision.v1.ImageAnnotatorSettings
import com.google.protobuf.ByteString
import java.io.FileInputStream
import java.io.IOException

object DetectText {
    /*
    @Throws(IOException::class)
    fun detectText(filePath: String?): List<String> {
        val credentialsPath = "D:\\UNQUI\\TIP\\bacco-backend\\src\\main\\resources\\bacco-back-dbdda54eb3a7.json"

        val credentials = GoogleCredentials.fromStream(FileInputStream(credentialsPath))

        val settings = ImageAnnotatorSettings.newBuilder().setCredentialsProvider { credentials }.build()

        return ImageAnnotatorClient.create(settings).use { client ->
            detectText(client, filePath)
        }
    }*/

    @Throws(IOException::class)
    fun detectText(client: ImageAnnotatorClient, filePath: String?): List<String> {
        val requests: MutableList<AnnotateImageRequest> = ArrayList()
        val imgBytes = ByteString.readFrom(FileInputStream(filePath!!))
        val img = Image.newBuilder().setContent(imgBytes).build()
        val feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build()
        val request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build()
        requests.add(request)

        val response = client.batchAnnotateImages(requests)
        val responses = response.responsesList
        return responses.flatMap{ res -> res.textAnnotationsList }.map{ annotation -> annotation.description }
    }
}
