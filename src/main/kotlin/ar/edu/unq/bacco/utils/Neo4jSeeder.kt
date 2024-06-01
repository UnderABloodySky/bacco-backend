package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.*
import ar.edu.unq.bacco.repository.BeverageRepository
import ar.edu.unq.bacco.repository.IngredientRepository
import ar.edu.unq.bacco.repository.RecipeRepository
import ar.edu.unq.bacco.repository.UserRepository
import org.springframework.stereotype.Component

@Component
class Neo4jSeeder(
    private val recipeRepository: RecipeRepository,
    private val beverageRepository: BeverageRepository,
    private val userRepository: UserRepository,
    private val ingredientRepository: IngredientRepository
) {

    fun seedDatabase() {
        System.out.println("START POPULATION OF DB")
        if (recipeRepository.count() == 0L && beverageRepository.count() == 0L) {
            val description = "“Ebis vendae eaqui solupta turera prepe parum ut estrum, cus as nient aut aut pa nost, consed ut reroribus ex ea dolor as secestrum qui con preprae sequam ipsaeperum is ipsamus aectibustior accae perovit quas as modipsunt ut volorro beatemolenis veremporum quianda perchil es quam eum"

            val fernet = Beverage(name = "FERNET", description = "El sabor auténtico de Cordoba y Argentina")
            val aguaTonica = Beverage(name = "TONICA", description = "Refrescante y versátil")
            val cocaCola = Beverage(name = "COCACOLA", description = "La chispa que necesitas")
            val gin = Beverage(name = "GIN", description = "La chispa que necesitas")
            val ron = Beverage(name = "RON", description = "Una aventura caribeña en tu vaso")
            val cerveza = Beverage(name = "CERVEZA", description = "La tradición en cada burbuja")
            val aperitivo = Beverage(name = "APERITIVO", description = "El toque perfecto antes de la cena")
            val licor = Beverage(name = "LICOR", description = "Dulce tentación en cada gota")
            val gancia = Beverage(name="GANCIA", description = "El espíritu italiano en tu copa")
            val whiskey = Beverage(name="WHISKEY", description = "Destilado de distinción y carácter")
            val vino = Beverage(name="VINO", description = "Elegancia embotellada")
            val beverages = listOf(fernet, aguaTonica, cocaCola, gin, ron, cerveza, aperitivo, licor, gancia, whiskey, vino)

            beverageRepository.saveAll(beverages)

            val pimienta = Ingredient(name = "Pimienta", description = "Toque de intensidad y sabor")
            val hielo = Ingredient(name = "Hielo", description = "Frescura garantizada en cada sorbo")
            val sal = Ingredient(name = "Sal", description = "Equilibrio perfecto para tu paladar")
            val leche = Ingredient(name = "Leche", description = "Suavidad inigualable en cada trago")
            val azucar = Ingredient(name = "Azucar", description = "Dulzura exquisita para deleitar tus sentidos")
            val menta = Ingredient(name = "Menta", description = "Frescor natural y refrescante")
            val jengibre = Ingredient(name = "Jengibre", description = "Toque picante y revitalizante")
            val pomelo = Ingredient(name = "Pomelo", description = "Refrescante y lleno de vitalidad")
            val limon = Ingredient(name = "Limon", description = "Acidez refrescante y cítrica")
            val naranja = Ingredient(name = "Naranja", description = "Dulzura cítrica y energizante")
            val pepino = Ingredient(name = "Pepino", description = "Refrescante y crujiente")
            val frutilla = Ingredient(name = "Frutilla", description = "Dulzura jugosa y deliciosa")
            val arandanos = Ingredient(name = "Arandanos", description = "Antioxidante natural y exquisito sabor")
            val frutosRojos = Ingredient(name = "Frutos rojos", description = "Vibrante y lleno de sabor")
            val aceitunas = Ingredient(name = "Aceitunas", description = "Toque mediterráneo de autenticidad")
            val hibiscus = Ingredient(name = "Hibiscus", description = "Roja como la sangre")
            val ingredients = listOf(pimienta, hielo, sal, leche, azucar, menta, jengibre, pomelo, limon, naranja, pepino, frutilla, aceitunas, frutosRojos, arandanos, hibiscus)

            ingredientRepository.saveAll(ingredients)

            val soloAperitivo = Recipe(name = "Solo aperitivo", description = description)
            soloAperitivo.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            soloAperitivo.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            soloAperitivo.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))


            val aperitivoYCerveza = Recipe(name = "Aperitivo y cerveza", description = description)
            aperitivoYCerveza.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            aperitivoYCerveza.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            aperitivoYCerveza.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val aperitivoCervezaYFernet = Recipe(name = "Aperitivo, cerveza y Fernet", description = description)
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            aperitivoCervezaYFernet.ingredients.add(RecipeIngredientRelationship(ingredient = hibiscus))
            aperitivoCervezaYFernet.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            aperitivoCervezaYFernet.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))

            val fernandito = Recipe(name = "Fernet", description = description)
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            fernandito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ginTonic = Recipe(name = "Gin Tonic", description = description)
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))

            val cubaLibre = Recipe(name = "Cuba Libre", description = description)
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val cosaRara = Recipe(name = "Cosa Rara y Fea", description = description)
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = gin))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cosaRara.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val cosaFea = Recipe(name = "Cosa Fea", description = description)
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaFea.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val michelada = Recipe(name = "Michelada", description = description)
            michelada.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            michelada.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            michelada.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val caranchito = Recipe(name = "Caranchito", description = description)
            caranchito.beverages.add(RecipeBeverageRelationship(beverage = vino))
            caranchito.beverages.add(RecipeBeverageRelationship(beverage = ron))
            caranchito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

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
