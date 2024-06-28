package ar.edu.unq.bacco.model.DTO

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("BeverageDTO's tests")
class BeverageDTOTest {
    @Test
    fun `create BeverageDTO`() {
        val beverageName = "Coffee"

        val beverageDTO = BeverageDTO(beverageName)

        assertThat(beverageDTO.name).isEqualTo(beverageName)
    }
}