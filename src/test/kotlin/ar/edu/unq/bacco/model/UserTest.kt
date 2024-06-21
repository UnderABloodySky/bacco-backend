package ar.edu.unq.bacco.model

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class UserTest {

    @Test
    fun createUserWithNonNullId() {
        val id = 1L
        val name = "John Doe"
        val user = User(id = id, name = name, password = "", email="")

        assertThat(user.id).isEqualTo(id)
        assertThat(user.name).isEqualTo(name)
    }

    @Test
    fun createUserWithNullId() {
        val name = "Alice"
        val user = User(name = name, password = "", email="")

        assertThat(user.id).isNull()
        assertThat(user.name).isEqualTo(name)
    }

    @Test
    fun updateUserName() {
        val id = 2L
        val user = User(id = id, name = "Bob", password = "", email="")

        val newName = "Charlie"
        user.name = newName

        assertThat(user.name).isEqualTo(newName)
    }
}
