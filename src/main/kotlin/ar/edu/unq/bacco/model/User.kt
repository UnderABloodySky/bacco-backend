package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class User(
    @Id @GeneratedValue var id: Long? = null,
    val name: String
)