package ar.edu.unq.bacco.repository

import ar.edu.unq.bacco.model.Comment
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : Neo4jRepository<Comment, Long>