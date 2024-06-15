package ar.edu.unq.bacco.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Property

@Node
data class User(
    @Id @GeneratedValue var id: Long? = null,

    @field:NotBlank(message = "El nombre no puede estar vacío")
    var name: String,

    @field:NotBlank(message = "La password no puede estar vacío")
    @Property("password") var password: String,

    @field:NotBlank(message = "El correo no puede estar vacío")
    @field:Email(message = "Debe ser un correo electrónico válido")
    @Property("email") val email: String
)