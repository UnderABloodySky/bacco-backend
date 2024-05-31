package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.support.UUIDStringGenerator

@Node
class Beverage(
    @Id @GeneratedValue(UUIDStringGenerator::class)
    var id: String? = null,
    val name: String
)