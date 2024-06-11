package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import org.apache.http.HttpStatus
import org.junit.jupiter.api.Assertions.assertEquals
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
import kotlin.properties.Delegates

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

    @BeforeEach
    fun setUp() {
        userController = UserController(userService, recipeService)
        userNoPersist = User(name = "Louis Amstrong")
        userPersist = userService.save(userNoPersist)

    }

    @Test
    @DisplayName("Create an user returns a Response with 200 code")
    fun testCreateUserReturnsAResponseWith200Code() {
        val response = userController.createUser(userNoPersist)
        assertEquals(201, response.statusCodeValue)
    }

    @Test
    @DisplayName("Create an user returns a status")
    fun testCreateUserReturnsAStatus() {
        val response = userController.createUser(userNoPersist)
        assertEquals(HttpStatusCode.valueOf(201), response.statusCode)
    }


    @Test
    @DisplayName("Find a user by ID returns a correct user when the ID is right")
    fun testFindByUserIdWithCorrectUserReturnAResponseWith200Code() {
        val response = userController.getUserById(userPersist.id!!)
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
        val user = userController.getUserById(userPersist.id!!).body
        assertEquals(user?.id, userPersist.id)
        assertEquals(user?.name, userPersist.name)
    }
}