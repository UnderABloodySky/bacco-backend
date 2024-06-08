package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
class Recipe (
    @Id @GeneratedValue var id: Long? = null,
    val name: String,
    val description: String,

    @Relationship(type = "OWNER", direction = Relationship.Direction.OUTGOING)
    var user: User? = null,

    var imagePath: String? = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/deuda_tecnica/assets/no_image.png",

    @Relationship(type = "HAS_BEVERAGES", direction = Relationship.Direction.OUTGOING)
    val beverages: MutableSet<RecipeBeverageRelationship> = mutableSetOf(),

    @Relationship(type = "HAS_INGREDIENTS", direction = Relationship.Direction.OUTGOING)
    val ingredients: MutableSet<RecipeIngredientRelationship> = mutableSetOf()
)