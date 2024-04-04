package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Recipe
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : Neo4jRepository<Recipe, Long>{

    @Query("MATCH (r:Recipe)-[:HAS_BEVERAGE]->(b:Beverage) WHERE b.name = {name} RETURN r")
    fun findByBeverageName(name: String): Iterable<Recipe>

    @Query("MATCH (r:Recipe)-[:HAS_BEVERAGE]->(b:Beverage) WHERE ALL(bev IN $0 WHERE bev IN [b.name]) RETURN r")
    fun findRecipesByBeverageNames(beverageNames: List<String>): List<Recipe>

}