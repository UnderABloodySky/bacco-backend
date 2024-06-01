package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Recipe
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : Neo4jRepository<Recipe, Long>{

    @Query("""
        MATCH (r:Recipe)-[rel:HAS_BEVERAGES]->(b:Beverage)
        WHERE ANY(name IN $0 WHERE (r)-[:HAS_BEVERAGES]->(:Beverage {name: name}))
        OPTIONAL MATCH (r)-[relIng:HAS_INGREDIENTS]->(i:Ingredient)
        RETURN DISTINCT r, 
               COLLECT(DISTINCT b) AS beverages, 
               COLLECT(DISTINCT rel) AS beverageRels, 
               COLLECT(DISTINCT i) AS ingredients, 
               COLLECT(DISTINCT relIng) AS ingredientRels
    """)
    fun findRecipesByBeverageNames(beverageNames: List<String>): List<Recipe>

    @Query("MATCH (r:Recipe)-[rel:HAS_INGREDIENTS]->(i:Ingredient) WHERE i.name IN $0 RETURN DISTINCT r, COLLECT(i) as ingredients, COLLECT(rel) as recipeIngredientRelationships")
    fun findRecipesByIngredientNames(beverageNames: List<String>): List<Recipe>


}