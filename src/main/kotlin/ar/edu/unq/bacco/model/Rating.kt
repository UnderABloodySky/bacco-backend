package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Rating(
    @Id @GeneratedValue var id: Long? = null,
    @Relationship(type = "RATED_BY", direction = Relationship.Direction.OUTGOING)
    val user: User,
    var score: Double
)
