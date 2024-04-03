package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
class Beverage(
    @Id @GeneratedValue var id: Long? = null,
    val name: String,

    @Relationship(type = "HAS_BEVERAGE", direction = Relationship.Direction.INCOMING)
    val recipes: MutableSet<Recipe> = mutableSetOf()
)
