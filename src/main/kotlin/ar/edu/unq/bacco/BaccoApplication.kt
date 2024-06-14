package ar.edu.unq.bacco

import ar.edu.unq.bacco.utils.Neo4jSeeder
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
class BaccoApplication(private val neo4jSeeder: Neo4jSeeder) : ApplicationRunner {

	override fun run(args: ApplicationArguments?) {
		neo4jSeeder.clearDatabase()
		neo4jSeeder.seedDatabase()
	}
}

fun main(args: Array<String>) {
	runApplication<BaccoApplication>(*args)
}
