package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Beverage
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface BeverageRepository : Neo4jRepository<Beverage, Long>{
    fun findByNameContainingIgnoreCase(name: String): List<Beverage>
}