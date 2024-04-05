package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.repository.BeverageRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import org.springframework.stereotype.Component

@Component
class Neo4jSeeder(private val recipeRepository: RecipeRepository, private val beverageRepository: BeverageRepository) {

    fun seedDatabase() {
        if (recipeRepository.count() == 0L && beverageRepository.count() == 0L) {
            val fernet = Beverage(name = "FERNET")
            val aguaTonica = Beverage(name = "TONICA")
            val cocaCola = Beverage(name = "COCACOLA")
            val gin = Beverage(name = "GIN")
            val ron = Beverage(name= "RON")

            beverageRepository.save(fernet)
            beverageRepository.save(aguaTonica)
            beverageRepository.save(gin)
            beverageRepository.save(ron)
            beverageRepository.save(cocaCola)


            val fernandito = Recipe(name = "Ferne", beverages = mutableSetOf(cocaCola, fernet))
            val ginTonic = Recipe(name = "Gin Tonic", beverages = mutableSetOf(gin, aguaTonica))
            val cubaLibre = Recipe(name = "Cubra Libre", beverages = mutableSetOf(cocaCola, ron))
            val cosaRara = Recipe(name="Cosa Rara y Fea", beverages = mutableSetOf(fernet, cocaCola, gin, ron))

            recipeRepository.save(fernandito)
            recipeRepository.save(ginTonic)
            recipeRepository.save(cubaLibre)
            recipeRepository.save(cosaRara)
        }
    }

    fun clearDatabase() {
        recipeRepository.deleteAll()
        beverageRepository.deleteAll()
        println("Todas las entidades han sido eliminadas de la base de datos.")
    }
}
