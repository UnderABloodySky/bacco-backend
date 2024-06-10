package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
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
class UserControllerTest {

    private lateinit var userController: UserController

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var recipeService: RecipeService

    @BeforeEach
    fun setUp() {
        userController = UserController(userService, recipeService)
    }

    @Test
    @Transactional
    fun testCreateUserWithoutMock() {
        val userNoPersist = User(name = "Pepe")
        val response = userController.createUser(userNoPersist)
        val user = response.body
        val userPersist = userController.getUserById(user?.id!!).body
        assertEquals(userNoPersist.name, userPersist?.name)
    }
}

/*
@TestPropertySource(locations = ["classpath:application-test.properties"])
@ActiveProfiles("test")
class UserControllerTest {

    private lateinit var userController: UserController

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var recipeService: RecipeService


    @BeforeEach
    fun setUp(){
        userController = UserController(userService, recipeService)
    }

    @Test
    fun testCreateMockUser() {
        val userServiceMock = mock(UserService::class.java)
        val recipeServiceMock = mock(RecipeService::class.java)
        val userController = UserController(userServiceMock, recipeServiceMock)
        val anUser = User(name = "John Coltrane")

        `when`(userServiceMock.save(anUser)).thenReturn(anUser)

        val response = userController.createUser(anUser)

        assertEquals(HttpStatus.CREATED, response.statusCode)
        assertEquals(anUser, response.body)
    }

    @Test
    fun testGetMockUserById() {
        val userServiceMock = mock(UserService::class.java)
        val recipeServiceMock = mock(RecipeService::class.java)
        val userController = UserController(userServiceMock, recipeServiceMock)
        val user = User(name = "Louis Amstrong")

        `when`(userServiceMock.findById(1L)).thenReturn(user)

        val response = userController.getUserById(1L)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(user, response.body)
    }

    @Test
    fun testCreateUserWithoutMock(){
        val userNoPersist = User(name = "Pepe")
        val response = userController.createUser(userNoPersist)
        val user = response.body
        val userPersist = userController.getUserById(user?.id!!).body
        assertEquals(userNoPersist.name, userPersist?.name)

    }
}
*/