package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Ingredient
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository


@Repository
interface IngredientRepository : Neo4jRepository<Ingredient, Long>