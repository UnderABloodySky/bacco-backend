package ar.edu.unq.bacco.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
@Node
class Comment(
    @Id
    @GeneratedValue
    var id: Long? = null,
    var content: String,
    @Relationship(type = "COMMENTED_BY", direction = Relationship.Direction.OUTGOING)
    var user: User,

    @Relationship(type = "COMMENT_ON", direction = Relationship.Direction.OUTGOING)
    @JsonBackReference
    @JsonIgnore
    var recipe: Recipe)