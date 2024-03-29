package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Transactional
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserControllerTest {

    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var userController: UserController

    @Test
    fun testCreateMockUser() {
        val userServiceMock = mock(UserService::class.java)
        val userController = UserController(userServiceMock)
        val anUser = User(name="John Coltrane") // Proporciona solo el nombre, el ID se generará automáticamente

        `when`(userServiceMock.save(anUser)).thenReturn(anUser)

        val response = userController.createUser(anUser)

        assertEquals(HttpStatus.CREATED, response.statusCode)
        assertEquals(anUser, response.body)
    }

    @Test
    fun testGetMockUserById() {
        val userServiceMock = mock(UserService::class.java)
        val userController = UserController(userServiceMock)
        val user = User(name="Louis Amstrong")

        `when`(userServiceMock.findById(1L)).thenReturn(user)

        val response = userController.getUserById(1L)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(user, response.body)
    }

    @Test
    fun `test createUser`() {
        val anUser = User(name = "Nina Simone")

        val response = userController.createUser(anUser)

        assertEquals(HttpStatus.CREATED, response.statusCode)
        assertEquals(anUser, response.body)
    }

    @Test
    fun `test getUserById`() {
        val user = User(name = "Buddy Rich")
        val savedUser = userService.save(user)

        val response = userController.getUserById(savedUser.id!!)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(user, response.body)
        assertEquals(user, savedUser)

    }
}
