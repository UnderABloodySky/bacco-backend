package ar.edu.unq.bacco.controller
import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.service.BeverageService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import org.springframework.mock.web.MockMultipartFile
import org.assertj.core.api.Assertions.assertThat
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.CloseableHttpClient
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@ExtendWith(MockitoExtension::class)
class BeverageControllerTest {

    @Mock
    private lateinit var beverageService: BeverageService

    @Mock
    private lateinit var httpClient: CloseableHttpClient

    private lateinit var beverageController: BeverageController

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        beverageController = BeverageController(beverageService, "http://localhost:8000/upload-photo-for-retrain")
    }

    @Test
    fun getBeveragesByNameReturnsBeverages() {
        val name = "Cola"
        val beverages = listOf(Beverage(name = name))
        `when`(beverageService.findBeveragesByName(name)).thenReturn(beverages)

        val result = beverageController.getBeveragesByName(name)

        assertThat(result).isEqualTo(beverages)
        verify(beverageService, times(1)).findBeveragesByName(name)
    }

    @Test
    fun sendPhotoForRetrainReturnsBadRequestWhenFileIsEmpty() {
        val file = MockMultipartFile("file", ByteArray(0))
        val beverage = "Cola"

        val response = beverageController.sendPhotoForRetrain(file, beverage)

        assertThat(response.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
        assertThat(response.body).isEqualTo("Por favor, selecciona un archivo")
    }

    @Test
    fun sendPhotoForRetrainReturnsInternalServerErrorOnException() {
        val file = MockMultipartFile("file", "test.jpg", "image/jpeg", ByteArray(1))
        val beverage = "Cola"
        
        val response = beverageController.sendPhotoForRetrain(file, beverage)

        assertThat(response.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
        assertThat(response.body).contains("Error al enviar la foto para reentrenamiento")
    }

    /*
    @Test
    fun sendPhotoForRetrainReturnsOkOnSuccessfulUpload() {
        val file = MockMultipartFile("file", "test.jpg", "image/jpeg", ByteArray(1))
        val beverage = "Cola"

        val mockResponse = mock(CloseableHttpResponse::class.java)
        `when`(mockResponse.statusLine).thenReturn(org.apache.http.message.BasicStatusLine(org.apache.http.HttpVersion.HTTP_1_1, HttpStatus.OK.value(), "OK"))
        `when`(mockResponse.entity).thenReturn(org.apache.http.entity.StringEntity("Success"))

        `when`(httpClient.execute(any(HttpPost::class.java))).thenReturn(mockResponse)

        val result = beverageController.sendPhotoForRetrain(file, beverage)

        assertThat(result.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result.body).isEqualTo("Success")
    }
*/
    @Test
    fun sendPhotoForRetrainReturnsInternalServerErrorOnFailedUpload() {
        val file = MockMultipartFile("file", "test.jpg", "image/jpeg", ByteArray(1))
        val beverage = "Cola"


        val result = beverageController.sendPhotoForRetrain(file, beverage)

        assertThat(result.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
        assertThat(result.body).isEqualTo("Error al enviar la foto para reentrenamiento: Connect to localhost:8000 [localhost/127.0.0.1] failed: Conexión rehusada")
    }
}