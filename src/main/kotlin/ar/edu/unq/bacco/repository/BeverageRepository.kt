package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.Recipe
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.data.neo4j.repository.query.Query
import org.springframework.stereotype.Repository

@Repository
interface BeverageRepository : Neo4jRepository<Beverage, Long>{

    @Query("MATCH (r:Recipe)-[:HAS_BEVERAGE]->(b:Beverage) WHERE b.name = {name} RETURN r")
    fun findByBeverageName(name: String): Iterable<Recipe>
}