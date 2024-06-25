package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Ingredient
import org.springframework.mock.web.MockMultipartFile
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.utils.MediatorBaccoCNN
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations.initMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@Suppress("DEPRECATION")
@DisplayName("RecipeController's tests")
@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class RecipeControllerTest {
/*
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
        initMocks(this)
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
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta")))
        val response = recipeController2.filterRecipes(listOf(), listOf("pimienta"))
        assertEquals(1, response.size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that only one recipe contains returns a list with an unique element")
    fun testWhenSearchRecipesByOneIngredientThatTwoRecipeContainsReturnsAnListWithTwoElements(){
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta", "hielo")))
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron", "fernet"), listOf("pimienta", "hielo")))
        val response = recipeController2.getTotalRecipes()
        assertEquals(2, response.size)
    }


    @Test
    @DisplayName("When search recipes by one ingredient that any recipe contains returns an empty list")
    fun testWhenSearchRecipesByOneBeverageThatAnyRecipeContainsReturnsAnEmptyList(){
        val response = recipeController2.filterRecipes(listOf("ron"), listOf("leche"))
        assertEquals(0, response.size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that only one recipe contains returns a list with an unique element")
    fun testWhenSearchRecipesByOneBeverageThatOneRecipeContainsReturnsAnListWithUniqueElement(){
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta")))
        val response = recipeController2.filterRecipes(listOf("ron"), listOf("pimienta"))
        assertEquals(1, response.size)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that only one recipe contains returns a list with an unique element")
    fun testWhenSearchRecipesByOneBeverageThatTwoRecipeContainsReturnsAnListWithTwoElements(){
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta", "hielo")))
        recipeController2.createRecipe(RecipeDTO("a name", "a description", listOf("ron", "fernet"), listOf("pimienta", "hielo")))
        val response = recipeController2.getTotalRecipes()
        assertEquals(2, response.size)
    }

    //ACA

    @Test
    @DisplayName("When search recipes by one ingredient that any recipe contains returns an empty list")
    fun testWhenSearchRecipesByOneIngredientThatAnyRecipeContainsReturnsAnEmptyListObject(){
        val response = recipeController2.filterRecipes(listOf(), listOf("leche"))
        assertEquals(listOf<Recipe?>(), response)
    }

    @Test
    @DisplayName("When search recipes by one ingredient that only one recipe contains returns a list with an unique element")
    fun testWhenSearchRecipesByOneIngredientThatOneRecipeContainsReturnsAnListWithUniqueElementObject(){
        val recipeDTO = RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta"))
        recipeController2.createRecipe(recipeDTO)
        val response = recipeController2.filterRecipes(listOf(), listOf("pimienta"))
        assertEquals(1, response.size)
        val recipe = response[0]
        assertInstanceOf(Recipe::class.java, recipe)
        assertEquals(recipeDTO.name, recipe!!.name)
        assertEquals(recipeDTO.description, recipe.description)
        assertEquals(1, recipe.ingredients.size)
        assertEquals(1, recipe.beverages.size)

        val ingredient = recipe.ingredients.toList()[0].ingredient
        assertInstanceOf(Ingredient::class.java, ingredient)
        assertEquals("PIMIENTA", ingredient.name)

        val beverage = recipe.beverages.toList()[0].beverage
        assertInstanceOf(Beverage::class.java, beverage)
        assertEquals("RON", beverage.name)
    }
    @Test

    @DisplayName("When search recipes by one ingredient that only one recipe contains returns a list with an unique element")
    fun testWhenSearchRecipesByOneIngredientThatTwoRecipeContainsReturnsAnListWithTwoElementsObjects(){
        val recipeDTO0 = RecipeDTO("a name", "a description", listOf("ron"), listOf("pimienta", "hielo"))
        val recipeDTO1 = RecipeDTO("a name", "a description", listOf("ron", "fernet"), listOf("pimienta", "hielo"))
        recipeController2.createRecipe(recipeDTO0)
        recipeController2.createRecipe(recipeDTO1)

        val response = recipeController2.filterRecipes(listOf(), listOf("pimienta"))
        assertEquals(2, response.size)

        val recipe0 = response[0]
        assertInstanceOf(Recipe::class.java, recipe0)
        assertEquals(recipeDTO0.name, recipe0!!.name)
        assertEquals(recipeDTO0.description, recipe0.description)
        assertEquals(2, recipe0.ingredients.size)
        assertEquals(1, recipe0.beverages.size)

        val recipe1 = response[0]
        assertInstanceOf(Recipe::class.java, recipe1)
        assertEquals(recipeDTO1.name, recipe1!!.name)
        assertEquals(recipeDTO1.description, recipe1.description)
        assertEquals(2, recipe1.ingredients.size)
        assertEquals(1, recipe1.beverages.size)

        val ingredient0 = recipe0.ingredients.toList()[0].ingredient
        assertInstanceOf(Ingredient::class.java, ingredient0)
        assertTrue("PIMIENTA" == ingredient0.name || "HIELO" == ingredient0.name)


        val ingredient1 = recipe0.ingredients.toList()[1].ingredient
        assertInstanceOf(Ingredient::class.java, ingredient0)
        assertTrue("PIMIENTA" == ingredient1.name || "HIELO" == ingredient1.name)

        val beverage = recipe0.beverages.toList()[0].beverage
        assertInstanceOf(Beverage::class.java, beverage)
        assertEquals("RON", beverage.name)

        val ingredient2 = recipe1.ingredients.toList()[0].ingredient
        assertInstanceOf(Ingredient::class.java, ingredient2)
        assertTrue("PIMIENTA" == ingredient2.name || "HIELO" == ingredient2.name)


        val ingredient3 = recipe1.ingredients.toList()[1].ingredient
        assertInstanceOf(Ingredient::class.java, ingredient3)
        assertTrue("PIMIENTA" == ingredient3.name || "HIELO" == ingredient3.name)


        val beverage1 = recipe1.beverages.toList()[0].beverage
        assertInstanceOf(Beverage::class.java, beverage)
        assertEquals("RON", beverage1.name)

    }*/
}
