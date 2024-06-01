package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.TargetNode

class RecipeIngredientRelationship(@TargetNode
var ingredient: Ingredient, var quantity: Int = 1){
    @Id
    @GeneratedValue
    var id: Long? = null
}