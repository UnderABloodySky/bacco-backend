package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Recipe
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : Neo4jRepository<Recipe, Long>{

    @Query("MATCH (r:Recipe)-[:HAS_BEVERAGES]->(b:Beverage) WHERE ALL(bev IN b.name WHERE bev IN $0) RETURN DISTINCT r")
    fun findRecipesByBeverageNames(beverageNames: List<String>): List<Recipe>

}