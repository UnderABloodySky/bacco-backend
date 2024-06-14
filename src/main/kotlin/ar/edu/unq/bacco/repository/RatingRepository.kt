package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Rating
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface RatingRepository : Neo4jRepository<Rating, Long> {

}