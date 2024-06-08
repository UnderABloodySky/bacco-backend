package ar.edu.unq.bacco.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
class Comment(
    @Id
    @GeneratedValue
    var id: Long? = null,
    val content: String,
    @Relationship(type = "COMMENTED_BY", direction = Relationship.Direction.OUTGOING)
    var user: User,

    @Relationship(type = "COMMENT_ON", direction = Relationship.Direction.OUTGOING)
    @JsonIgnore
    var recipe: Recipe)