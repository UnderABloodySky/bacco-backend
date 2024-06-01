package ar.edu.unq.bacco.model


import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.RelationshipProperties
import org.springframework.data.neo4j.core.schema.TargetNode

@RelationshipProperties
class RecipeBeverageRelationship(@TargetNode var beverage: Beverage, var measure: Int = 1){
    @Id
    @GeneratedValue
    var id: Long? = null
}