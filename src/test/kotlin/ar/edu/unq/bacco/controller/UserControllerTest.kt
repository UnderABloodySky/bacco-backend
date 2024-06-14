package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatusCode
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

/*
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.repository.UserRepository
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import ar.edu.unq.bacco.service.interfaces.UserServiceI
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

package ar.edu.unq.bacco.controller
*/

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisplayName("UserController - Test: ")
class UserControllerTest {

    private lateinit var userController: UserController

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var recipeService: RecipeService
    private lateinit var userNoPersist: User
    private lateinit var userPersist: User
    private lateinit var recipeDTO: RecipeDTO

    @BeforeEach
    fun setUp() {
        userController = UserController(userService, recipeService)
        userNoPersist = User(name = "Louis Amstrong")
        userPersist = userService.save(userNoPersist)
        recipeDTO = RecipeDTO("a name", "a description", listOf("GIN"), listOf("HIELO", "HIBISCUS"))
    }

    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testToCreateAnUserTHeIDIsNotull() {
        assertNotNull(userNoPersist.id, "The user ID should not be null after saving.")
        assertNotNull(userPersist.id, "The user ID should not be null after saving.")
    }

    @Test
    @DisplayName("Create an user returns a Response with 200 code")
    fun testCreateUserReturnsAResponseWith200Code() {
        val otherUser = User(name = "Louis Amstrong")
        val response = userController.createUser(otherUser)
        assertEquals(201, response.statusCodeValue)
    }

    @Test
    @DisplayName("Create an user returns a status")
    fun testCreateUserReturnsAStatus() {
        val otherUser = User(name = "Louis Amstrong")
        val response = userController.createUser(otherUser)
        assertEquals(HttpStatusCode.valueOf(201), response.statusCode)
    }

    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testFindByUserIdWithCorrectUserReturnAResponseWith200Code() {
        val otherUser = User(name = "Louis Amstrong")
        userService.save(otherUser)
        println(otherUser.id!!)
        val response = userController.getUserById(otherUser.id!!)
        assertEquals(200, response.statusCodeValue)
    }

    @Test
    @DisplayName("Find by user Id with correct user return a response with 200 status code")
    fun testFindByUserIdWithCorrectUserReturnAResponseWith200status() {
        val response = userController.getUserById(userPersist.id!!)
        assertEquals(HttpStatusCode.valueOf(200), response.statusCode)
    }

    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testFindByUserIdReturnsCorrectUser() {
        val user = userController.getUserById(userPersist.id!!).body as User
        assertEquals(user.id, userPersist.id)
        assertEquals(user.name, userPersist.name)
    }

    @Test
    @DisplayName("An user can create a recipe returns status")
    fun testAnUserCanCreateARecipeReturnsStatus() {
        val response = userController.addRecipe(userPersist.id!!, recipeDTO)
        assertEquals(HttpStatusCode.valueOf(201), response.statusCode)
    }

    @Test
    @DisplayName("An user can create a recipe returns code")
    fun testAnUserCanCreateARecipeReturnsCode() {
        val response = userController.addRecipe(userPersist.id!!, recipeDTO)
        assertEquals(201, response.statusCodeValue)
    }


    @Test
    @DisplayName("An user can create a recipe")
    fun testAnUserCanCreateARecipe() {
        val recipe = userController.addRecipe(userPersist.id!!, recipeDTO).body
        assertInstanceOf(Recipe::class.java, recipe)
    }

    @Test
    @DisplayName("An user cannot created a recipe without beverages")
    fun testAnUserCannotCreatedARecipeWithoutBeverages() {
        val wrongDTO = RecipeDTO("a name", "a description", listOf(""), listOf("HIBISCUS"))
        val response = userController.addRecipe(userPersist.id!!, wrongDTO)
        assertEquals(HttpStatusCode.valueOf(201),response.statusCode)
    }

    @Test
    @DisplayName("An user create an rspecific recipe")
    fun testAnUserCreateAnEspecificRecipe() {
        val recipe = userController.addRecipe(userPersist.id!!, recipeDTO).body
        assertEquals(recipeDTO.name, recipe!!.name)
        assertEquals(recipeDTO.description, recipe.description)
        assertEquals(recipeDTO.beverages.size, recipe.beverages.size)
        assertEquals(recipeDTO.beverages, recipe.beverages.map{bev -> bev.beverage.name})
        assertEquals(recipeDTO.ingredients, recipe.ingredients.map {ing -> ing.ingredient.name})
        assertEquals(recipeDTO.beverages.size, recipe.beverages.size)
        assertEquals(userPersist.id, recipe.user!!.id)
        assertEquals(userPersist, recipe.user)
    }
}