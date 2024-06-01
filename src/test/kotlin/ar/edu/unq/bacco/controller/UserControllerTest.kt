package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Test
    fun testCreateMockUser() {
        val userServiceMock = mock(UserService::class.java)
        val userController = UserController(userServiceMock)
        val anUser = User(name = "John Coltrane")

        `when`(userServiceMock.save(anUser)).thenReturn(anUser)

        val response = userController.createUser(anUser)

        assertEquals(HttpStatus.CREATED, response.statusCode)
        assertEquals(anUser, response.body)
    }

    @Test
    fun testGetMockUserById() {
        val userServiceMock = mock(UserService::class.java)
        val userController = UserController(userServiceMock)
        val user = User(name = "Louis Amstrong")

        `when`(userServiceMock.findById(1L)).thenReturn(user)

        val response = userController.getUserById(1L)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(user, response.body)
    }
}
