package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Recipe
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : Neo4jRepository<Recipe, Long>{

    @Query("""
        MATCH (r:Recipe)-[relBev:HAS_BEVERAGES]->(b:Beverage)
        WHERE ANY(name IN $0 WHERE (r)-[:HAS_BEVERAGES]->(:Beverage {name: name}))
        OPTIONAL MATCH (r)-[relIng:HAS_INGREDIENTS]->(i:Ingredient)
        RETURN DISTINCT r, 
               COLLECT(DISTINCT b) AS beverages, 
               COLLECT(DISTINCT relBev) AS beverageRels, 
               COLLECT(DISTINCT i) AS ingredients, 
               COLLECT(DISTINCT relIng) AS ingredientRels
    """)
    fun findRecipesByBeverageNames(beverageNames: List<String>): List<Recipe>

//  TODO: Fix this query, it's currently returning all Recipes no matter "beverageOrIngredientNames" content
    @Query("""
        MATCH (r:Recipe)
        OPTIONAL MATCH (r)-[relBeverage:HAS_BEVERAGES]->(b:Beverage)
        OPTIONAL MATCH (r)-[relIngredient:HAS_INGREDIENTS]->(i:Ingredient)
        WHERE ANY(name IN $0 WHERE (b.name = name)) OR 
              ANY(name IN $0 WHERE (i.name = name))
        RETURN DISTINCT r, 
               COLLECT(DISTINCT b) AS beverages, 
               COLLECT(DISTINCT relBeverage) AS beverageRels, 
               COLLECT(DISTINCT i) AS ingredients, 
               COLLECT(DISTINCT relIngredient) AS ingredientRels
    """)
    fun findRecipesByBeverageOrIngredientNames(beverageOrIngredientNames: List<String>): List<Recipe>

    @Query("""
        MATCH (r:Recipe)-[relIng:HAS_INGREDIENTS]->(i:Ingredient)
        WHERE ANY(name IN $0 WHERE (r)-[:HAS_INGREDIENTS]->(:Ingredient {name: name}))
        OPTIONAL MATCH (r)-[relBev:HAS_BEVERAGES]->(b:Beverage)
        RETURN DISTINCT r, 
               COLLECT(DISTINCT b) AS beverages, 
               COLLECT(DISTINCT relBev) AS beverageRels, 
               COLLECT(DISTINCT i) AS ingredients, 
               COLLECT(DISTINCT relIng) AS ingredientRels
    """)
    fun findRecipesByIngredientNames(ingredientNames: List<String>): List<Recipe>
}