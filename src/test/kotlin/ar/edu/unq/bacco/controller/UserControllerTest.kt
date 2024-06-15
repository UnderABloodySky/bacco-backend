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


@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisplayName("UserController - Test: ")
class UserControllerTest {


    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var recipeService: RecipeService

    private lateinit var userController: UserController

    @BeforeEach
    fun setUp() {
        userController = UserController(userService, recipeService)
    }

    @Test
    @Transactional
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testToCreateAnUserTHeIDIsNotull() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val userNoPersist = User(name="AnUsername2", password="12345678", email="asd420@gmail.com")
        userService.save(userNoPersist)

        assertNotNull(userNoPersist.id, "The user ID should not be null after saving.")
        assertNotNull(userPersist.id, "The user ID should not be null after saving.")
    }

    @Test
    @DisplayName("Create an user returns a Response with 200 code")
    fun testCreateUserReturnsAResponseWith200Code() {
        val otherUser = User(name = "epa", password = "123456789", email="asd@gmail.com")
        val response = userController.createUser(otherUser)
        assertEquals(HttpStatusCode.valueOf(201), response.statusCode)
    }

    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testFindByUserIdWithCorrectUserReturnAResponseWith200Code() {
        val otherUser = User(name = "Pepa", password = "12345678", email="asdf@gmail.com")
        userService.save(otherUser)
        println(otherUser.id!!)
        val response = userController.getUserById(otherUser.id!!)
        assertEquals(200, response.statusCodeValue)
    }


    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testCanotCreateAnUserWithSameName() {
        val user = User(name = "Pepa", password = "12345678", email="asdf@gmail.com")
        userController.createUser(user)
        val otherUser = User(name = "Pepa", password = "12345678", email="asdf@gmail.com")
        val response = userController.createUser(otherUser)
        assertEquals(400, response.statusCodeValue)
    }


    @Test
    @DisplayName("Find by user Id with correct user return a response with 200 status code")
    fun testFindByUserIdWithCorrectUserReturnAResponseWith200status() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val response = userController.getUserById(userPersist.id!!)
        assertEquals(HttpStatusCode.valueOf(200), response.statusCode)
    }

    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testFindByUserIdReturnsCorrectUser() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val user = userController.getUserById(userPersist.id!!).body as User
        assertEquals(user.id, userPersist.id)
        assertEquals(user.name, userPersist.name)
    }

    @Test
    @DisplayName("An user can create a recipe returns status")
    fun testAnUserCanCreateARecipeReturnsStatus() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val recipeDTO = RecipeDTO("aName", "aDescription", listOf("ron"), listOf("hielo"))

        val response = userController.addRecipe(userPersist.id!!, recipeDTO)
        assertEquals(HttpStatusCode.valueOf(201), response.statusCode)
    }

    @Test
    @DisplayName("An user can create a recipe returns code")
    fun testAnUserCanCreateARecipeReturnsCode() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val recipeDTO = RecipeDTO("aName", "aDescription", listOf("ron"), listOf("hielo"))

        val response = userController.addRecipe(userPersist.id!!, recipeDTO)
        assertEquals(201, response.statusCodeValue)
    }


    @Test
    @DisplayName("An user can create a recipe")
    fun testAnUserCanCreateARecipe() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val recipeDTO = RecipeDTO("aName", "aDescription", listOf("ron"), listOf("hielo"))
        val recipe = userController.addRecipe(userPersist.id!!, recipeDTO).body
        assertInstanceOf(Recipe::class.java, recipe)
    }

    @Test
    @DisplayName("An user cannot created a recipe without beverages")
    fun testAnUserCannotCreatedARecipeWithoutBeverages() {
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
        val wrongDTO = RecipeDTO("a name", "a description", listOf(""), listOf("HIBISCUS"))
        val response = userController.addRecipe(userPersist.id!!, wrongDTO)
        assertEquals(HttpStatusCode.valueOf(400),response.statusCode)
    }

    @Test
    @Transactional
    @DisplayName("An user create an rspecific recipe")
    fun testAnUserCreateAnEspecificRecipe() {
        val recipeDTO = RecipeDTO("aName", "aDescription", listOf("RON"), listOf("HIELO"))
        val userPersist = User(name="AnUsername", password="12345678", email="asd42@gmail.com")
        userService.save(userPersist)
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