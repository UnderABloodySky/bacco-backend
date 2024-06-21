package ar.edu.unq.bacco.model

import com.fasterxml.jackson.annotation.JsonIdentityInfo
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.ObjectIdGenerators
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship


@Node
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
class Recipe (
    @Id @GeneratedValue var id: Long? = null,
    val name: String,
    val description: String,

    @Relationship(type = "OWNER", direction = Relationship.Direction.OUTGOING)
    var user: User? = null,

    var imagePath: String? = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/no_image.png",

    @Relationship(type = "HAS_BEVERAGES", direction = Relationship.Direction.OUTGOING)
    val beverages: MutableSet<RecipeBeverageRelationship> = mutableSetOf(),

    @Relationship(type = "HAS_INGREDIENTS", direction = Relationship.Direction.OUTGOING)
    val ingredients: MutableSet<RecipeIngredientRelationship> = mutableSetOf(),

    @Relationship(type = "HAS_COMMENTS", direction = Relationship.Direction.OUTGOING)
    @JsonManagedReference
    var comments: MutableSet<Comment> = mutableSetOf(),

    @Relationship(type = "RATED", direction = Relationship.Direction.OUTGOING)
    val ratings: MutableSet<Rating> = mutableSetOf()) {

    fun rate(user: User, score: Double): Rating {
        if (score in 0.0..5.0) {
            val existingRating = ratings.find { it.user.id == user.id }
            if (existingRating != null) {
                existingRating.score = score
                return existingRating
            } else {
                val rating = Rating(user = user, score = score)
                ratings.add(rating)
                return rating
            }
        } else {
            throw IllegalArgumentException("Score must be between 0 and 5")
        }
    }

    fun averageRating(): Double {
        return if (ratings.isNotEmpty()) {
            ratings.map { it.score }.average()
        } else {
            0.0
        }
    }
}