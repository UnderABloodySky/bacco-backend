package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.RecipeBeverageRelationship
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : Neo4jRepository<Recipe, Long>{

    @Query("MATCH (r:Recipe)-[rel:HAS_BEVERAGES]->(b:Beverage) WHERE b.name IN $0 RETURN DISTINCT r, COLLECT(b) as beverages, COLLECT(rel) as recipeBeverageRelationships")
    fun findRecipesByBeverageNames(beverageNames: List<String>): List<Recipe>

    @Query("MATCH (r:Recipe)-[rel:HAS_INGREDIENTS]->(i:Ingredient) WHERE i.name IN $0 RETURN DISTINCT r, COLLECT(b) as ingredients, COLLECT(rel) as recipeIngredientRelationships")
    fun findRecipesByIngredientNames(beverageNames: List<String>): List<Recipe>


}