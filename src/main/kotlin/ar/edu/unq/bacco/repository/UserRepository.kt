package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.User
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : Neo4jRepository<User, Long>{
    fun findByName(username: String): Optional<User>
    fun findByEmail(email: String): Optional<User>
}