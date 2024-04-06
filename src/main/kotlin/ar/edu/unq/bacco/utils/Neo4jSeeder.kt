package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.RecipeBeverageRelationship
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
            val ron = Beverage(name = "RON")
            val cerveza = Beverage(name = "CERVEZA")

            beverageRepository.saveAll(listOf(fernet, aguaTonica, cocaCola, gin, ron, cerveza))

            val fernandito = Recipe(name = "Ferne")
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))

            val ginTonic = Recipe(name = "Gin Tonic")
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))

            val cubaLibre = Recipe(name = "Cubra Libre")
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = ron))

            val cosaRara = Recipe(name = "Cosa Rara y Fea")
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = gin))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = ron))

            val cosaFea = Recipe(name = "Cosa Fea")
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = fernet))

            val michelada = Recipe(name = "Michelada")
            michelada.beverages.add(RecipeBeverageRelationship(beverage = cerveza))

            recipeRepository.saveAll(listOf(fernandito, ginTonic, cubaLibre, cosaRara, cosaFea, michelada))
        }
    }

    fun clearDatabase() {
        recipeRepository.deleteAll()
        beverageRepository.deleteAll()
        println("Todas las entidades han sido eliminadas de la base de datos.")
    }
}
