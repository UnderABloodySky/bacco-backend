package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.RecipeBeverageRelationship
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.repository.BeverageRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class Neo4jSeeder(private val recipeRepository: RecipeRepository, private val beverageRepository: BeverageRepository, private val userRepository : UserRepository) {

    fun seedDatabase() {
        System.out.println("START POPULATION OF DB")
        if (recipeRepository.count() == 0L && beverageRepository.count() == 0L) {
            val description = "“Ebis vendae eaqui solupta turera prepe parum ut estrum, cus as nient aut aut pa nost, consed ut reroribus ex ea dolor as secestrum qui con preprae sequam ipsaeperum is ipsamus aectibustior accae perovit quas as modipsunt ut volorro beatemolenis veremporum quianda perchil es quam eum"

            val fernet = Beverage(name = "FERNET")
            val aguaTonica = Beverage(name = "TONICA")
            val cocaCola = Beverage(name = "COCACOLA")
            val gin = Beverage(name = "GIN")
            val ron = Beverage(name = "RON")
            val cerveza = Beverage(name = "CERVEZA")
            val aperitivo = Beverage(name = "APERITIVO")
            val licor = Beverage(name = "LICOR")
            val gancia = Beverage(name="VINO")
            val whiskey = Beverage(name="WHISKEY")
            val vino = Beverage(name="vino")
            val beverages = listOf(fernet, aguaTonica, cocaCola, gin, ron, cerveza, aperitivo, licor, gancia, whiskey, vino)

            beverageRepository.saveAll(beverages)

            val soloAperitivo = Recipe(name = "Solo aperitivo", description = description)
            soloAperitivo.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))

            val aperitivoYCerveza = Recipe(name = "Aperitivo y cerveza", description = description)
            aperitivoYCerveza.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            aperitivoYCerveza.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))

            val aperitivoCervezaYFernet = Recipe(name = "Aperitivo, cerveza y Fernet", description = description)
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = fernet))

            val fernandito = Recipe(name = "Fernet", description = description)
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))

            val ginTonic = Recipe(name = "Gin Tonic", description = description)
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))

            val cubaLibre = Recipe(name = "Cuba Libre", description = description)
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = ron))

            val cosaRara = Recipe(name = "Cosa Rara y Fea", description = description)
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = gin))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = ron))

            val cosaFea = Recipe(name = "Cosa Fea", description = description)
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = fernet))

            val michelada = Recipe(name = "Michelada", description = description)
            michelada.beverages.add(RecipeBeverageRelationship(beverage = cerveza))

            val caranchito = Recipe(name = "Caranchito", description = description)
            caranchito.beverages.add(RecipeBeverageRelationship(beverage = vino))
            caranchito.beverages.add(RecipeBeverageRelationship(beverage = ron))

            val recipes = listOf(soloAperitivo, aperitivoCervezaYFernet, aperitivoYCerveza,
                fernandito, ginTonic, cubaLibre, cosaRara, cosaFea, michelada)

            recipeRepository.saveAll(recipes)

            val user0 = User(name = "HValenzuela")
            val user1 = User(name = "fedecame")
            val user2 = User(name = "test")
            val users = listOf(user0, user1, user2)

            userRepository.saveAll(users)
        }
        println("END POPULATION OF DB")
    }

    fun clearDatabase() {
        println("START CLEAR DATABASE")
        recipeRepository.deleteAll()
        beverageRepository.deleteAll()
        userRepository.deleteAll()
        println("END CLEAR DATABASE")
    }
}
