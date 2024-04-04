package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.utils.Neo4jSeeder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/seed")
class SeederController(private val neo4jSeeder: Neo4jSeeder) {

    @PostMapping
    fun seedDatabase(): String {
        neo4jSeeder.seedDatabase()
        return "La base de datos ha sido sembrada con éxito."
    }
}