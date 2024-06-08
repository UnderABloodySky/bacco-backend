package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import ar.edu.unq.bacco.service.interfaces.UserServiceI
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

@TestPropertySource(locations = ["classpath:application-test.properties"])
@ActiveProfiles("test")
class UserControllerTest {

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
    fun test(){

    }
}
