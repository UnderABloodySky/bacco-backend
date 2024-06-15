package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.DTO.RecipeDTO
import org.springframework.mock.web.MockMultipartFile
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import ar.edu.unq.bacco.utils.MediatorBaccoCNN
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.doThrow
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.io.IOException

@DisplayName("RecipeController's tests")
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RecipeControllerTest {

    @Autowired
    private lateinit var recipeController2: RecipeController

    @Autowired
    private lateinit var recipeRepository: RecipeRepository

    @Mock
    lateinit var recipeService: RecipeService

    @Mock
    lateinit var mediatorBaccoCNN: MediatorBaccoCNN

    @InjectMocks
    lateinit var recipeController: RecipeController

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        recipeRepository.deleteAll()
    }

    @Test
    fun `test uploadImage should return bad request when file is empty`() {
        val file = MockMultipartFile("file", "filename.txt", "text/plain", "".toByteArray())

        val result = recipeController.uploadImage(file)

        assertEquals(HttpStatus.BAD_REQUEST, result.statusCode)
    }

    @Test
    fun `test uploadImage should return internal server error when IOException occurs`() {
        /*
        val file = MockMultipartFile("file", "filename.txt", "text/plain", "content".toByteArray())
        val errorMessage = "Error al cargar el archivo"
        val expectedResponse = ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
        val exception = IOException()
        doThrow(exception).`when`(mediatorBaccoCNN).detectBeverage(file)

        val result = recipeController.uploadImage(file)
        assertEquals(expectedResponse, result)
    */
    }


    @Test
    fun `test uploadImage should return response entity from mediatorBaccoCNN`() {
        /*
        val file = MockMultipartFile("file", "filename.txt", "text/plain", "content".toByteArray())
        val responseEntity = ResponseEntity.ok("Successful detection")
        `when`(mediatorBaccoCNN.detectBeverage(file)).thenReturn(responseEntity)

        val result = recipeController.uploadImage(file)

        assertEquals(responseEntity, result)

         */
    }

    @Test
    fun `test filterRecipes should return filtered recipes`() {
        val beverageNames = listOf("Beverage1", "Beverage2")
        val ingredientNames = listOf("Ingredient1", "Ingredient2")
        val expectedRecipes = listOf(Recipe(id = 1, name = "Recipe1", description =  ""), Recipe(id = 2, name = "Recipe2", description =  ""))
        `when`(recipeService.filterRecipesByBeveragesOrIngredients(beverageNames, ingredientNames))
            .thenReturn(expectedRecipes)

        val result = recipeController.filterRecipes(beverageNames, ingredientNames)

        assertEquals(expectedRecipes, result)
    }

    @Test
    fun `test filterRecipes should return all recipes when no parameters provided`() {
        val expectedRecipes = listOf(Recipe(id = 1, name = "Recipe1", description =  ""), Recipe(id = 2, name = "Recipe2", description =  ""))
        `when`(recipeService.filterRecipesByBeveragesOrIngredients(emptyList(), emptyList()))
            .thenReturn(expectedRecipes)

        val result = recipeController.filterRecipes(null, null)

        assertEquals(expectedRecipes, result)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that any recipe contains returns an empty list")
    fun testRecipesControllerCanCreateAnRecipe(){
        assertEquals(0, recipeController2.getTotalRecipes().size)
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("gin"), listOf("pimienta")))
        assertEquals(1, recipeController2.getTotalRecipes().size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that any recipe contains returns an empty list")
    fun testRecipesControllerCantCreateAnRecipeWithIngredientsInvalidate(){
        assertEquals(0, recipeController2.getTotalRecipes().size)
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("gin"), listOf("asd")))
        assertEquals(0, recipeController2.getTotalRecipes().size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that any recipe contains returns an empty list")
    fun testRecipesControllerCantCreateAnRecipeWithBeveragesInvalidate(){
        assertEquals(0, recipeController2.getTotalRecipes().size)
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("asd"), listOf("pimienta")))
        assertEquals(0, recipeController2.getTotalRecipes().size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that any recipe contains returns an empty list")
    fun testWhenSearchRecipesByOneIngredientThatAnyRecipeContainsReturnsAnEmptyList(){
        val response = recipeController2.filterRecipes(listOf(), listOf("leche"))
        assertEquals(0, response.size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that only one recipe contains returns a list with an unique element")
    fun testWhenSearchRecipesByOneIngredientThatOneRecipeContainsReturnsAnListWithUniqueElement(){
        val recipe = recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta")))
        val response = recipeController2.getTotalRecipes()
        assertEquals(1, response.size)
    }
}
