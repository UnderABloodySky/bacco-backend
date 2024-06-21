package ar.edu.unq.bacco.utils

import ar.edu.unq.bacco.model.*
import ar.edu.unq.bacco.repository.*
import org.springframework.stereotype.Component

@Component
class Neo4jSeeder(
    private val recipeRepository: RecipeRepository,
    private val beverageRepository: BeverageRepository,
    private val userRepository: UserRepository,
    private val ingredientRepository: IngredientRepository,
    private val commentRepository: CommentRepository,
    private val ratingRepository: RatingRepository
) {

    fun seedDatabase() {
       println("START POPULATION OF DB")
        if (recipeRepository.count() == 0L && beverageRepository.count() == 0L) {
            val description = "“Ebis vendae eaqui solupta turera prepe parum ut estrum, cus as nient aut aut pa nost, consed ut reroribus ex ea dolor as secestrum qui con preprae sequam ipsaeperum is ipsamus aectibustior accae perovit quas as modipsunt ut volorro beatemolenis veremporum quianda perchil es quam eum"

            val fernet = Beverage(name = "FERNET", description = "El sabor auténtico de Cordoba y Argentina", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/fernet.jpg")
            val aguaTonica = Beverage(name = "TONICA", description = "Refrescante y versátil", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val cocaCola = Beverage(name = "COCACOLA", description = "La chispa que necesitas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val gin = Beverage(name = "GIN", description = "La chispa que necesitas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val ron = Beverage(name = "RON", description = "Una aventura caribeña en tu vaso", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val cerveza = Beverage(name = "CERVEZA", description = "La tradición en cada burbuja", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val aperitivo = Beverage(name = "APERITIVO", description = "El toque perfecto antes de la cena", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val licor = Beverage(name = "LICOR", description = "Dulce tentación en cada gota", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val gancia = Beverage(name="GANCIA", description = "El espíritu italiano en tu copa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val whiskey = Beverage(name="WHISKEY", description = "Destilado de distinción y carácter", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val vino = Beverage(name="VINO", description = "Elegancia embotellada", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val beverages = listOf(fernet, aguaTonica, cocaCola, gin, ron, cerveza, aperitivo, licor, gancia, whiskey, vino)

            beverageRepository.saveAll(beverages)

            val pimienta = Ingredient(name = "PIMIENTA", description = "Toque de intensidad y sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val hielo = Ingredient(name = "HIELO", description = "Frescura garantizada en cada sorbo", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val sal = Ingredient(name = "SAL", description = "Equilibrio perfecto para tu paladar", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val leche = Ingredient(name = "LECHE", description = "Suavidad inigualable en cada trago", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val azucar = Ingredient(name = "AZUCAR", description = "Dulzura exquisita para deleitar tus sentidos", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val menta = Ingredient(name = "MENTA", description = "Frescor natural y refrescante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val jengibre = Ingredient(name = "JENGIBRE", description = "Toque picante y revitalizante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val pomelo = Ingredient(name = "POMELO", description = "Refrescante y lleno de vitalidad", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val limon = Ingredient(name = "LIMON", description = "Acidez refrescante y cítrica", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val naranja = Ingredient(name = "NARANJA", description = "Dulzura cítrica y energizante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val pepino = Ingredient(name = "PEPINO", description = "Refrescante y crujiente", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val frutilla = Ingredient(name = "FRUTILLA", description = "Dulzura jugosa y deliciosa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val arandanos = Ingredient(name = "ARANDANOS", description = "Antioxidante natural y exquisito sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val frutosRojos = Ingredient(name = "FRUTOS ROJOS", description = "Vibrante y lleno de sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val aceitunas = Ingredient(name = "ACEITUNAS", description = "Toque mediterráneo de autenticidad", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val hibiscus = Ingredient(name = "HIBISCUS", description = "Roja como la sangre", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/ingredient.jpg")
            val ingredients = listOf(pimienta, hielo, sal, leche, azucar, menta, jengibre, pomelo, limon, naranja, pepino, frutilla, aceitunas, frutosRojos, arandanos, hibiscus)

            ingredientRepository.saveAll(ingredients)

            val soloAperitivo = Recipe(name = "Solo aperitivo", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            soloAperitivo.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            soloAperitivo.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            soloAperitivo.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))


            val aperitivoYCerveza = Recipe(name = "Aperitivo y cerveza", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            aperitivoYCerveza.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            aperitivoYCerveza.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            aperitivoYCerveza.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val aperitivoCervezaYFernet = Recipe(name = "Aperitivo, cerveza y Fernet", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = aperitivo))
            aperitivoCervezaYFernet.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            aperitivoCervezaYFernet.ingredients.add(RecipeIngredientRelationship(ingredient = hibiscus))
            aperitivoCervezaYFernet.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            aperitivoCervezaYFernet.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))

            val fernandito = Recipe(name = "Fernet", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/fernet.jpg")
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            fernandito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ginTonic = Recipe(name = "Gin Tonic", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))

            val cubaLibre = Recipe(name = "Cuba Libre", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val cosaRara = Recipe(name = "Cosa Rara y Fea", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = gin))
            cosaRara.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cosaRara.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val cosaFea = Recipe(name = "Cosa Fea", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            cosaFea.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cosaFea.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val michelada = Recipe(name = "Michelada", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            michelada.beverages.add(RecipeBeverageRelationship(beverage = cerveza))
            michelada.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            michelada.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val caranchito = Recipe(name = "Caranchito", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            caranchito.beverages.add(RecipeBeverageRelationship(beverage = vino))
            caranchito.beverages.add(RecipeBeverageRelationship(beverage = ron))
            caranchito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val fernetPomelo = Recipe(name = "Fernet Pomelo", description = "Un trago refrescante y amargo, ideal para una tarde de verano", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/fernetPomelo.jpg")
            fernetPomelo.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernetPomelo.ingredients.add(RecipeIngredientRelationship(ingredient = pomelo))
            fernetPomelo.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ganciaFrutillaMenta = Recipe(name = "Gancia Frutilla mentolada", description = "Una combinación dulce y refrescante con un toque de menta", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/ganciaFrutilla.jpg")
            ganciaFrutillaMenta.beverages.add(RecipeBeverageRelationship(beverage = gancia))
            ganciaFrutillaMenta.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            ganciaFrutillaMenta.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            ganciaFrutillaMenta.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ronLimonado = Recipe(name = "Ron Limonado", description = "Un clásico ron con un toque cítrico y refrescante", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/ronLiimon.jpg")
            ronLimonado.beverages.add(RecipeBeverageRelationship(beverage = ron))
            ronLimonado.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            ronLimonado.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            ronLimonado.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val tintillo = Recipe(name = "Tintillo de verano con Frutos Rojos", description = "Un trago elegante con la mezcla perfecta de vino tinto y frutas", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/tintillo.jpg")
            tintillo.beverages.add(RecipeBeverageRelationship(beverage = vino))
            tintillo.ingredients.add(RecipeIngredientRelationship(ingredient = arandanos))
            tintillo.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            tintillo.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val whiskeyGinger = Recipe(name = "Whiskey Ginger", description = "Un clásico trago con la combinación perfecta de whiskey y jengibre", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/whiskeyginger.jpg")
            whiskeyGinger.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = jengibre))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val licorMenta = Recipe(name = "Licor mentolado", description = "Un trago refrescante y simple, perfecto para una noche relajante", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/licormenta.jpg")
            whiskeyGinger.beverages.add(RecipeBeverageRelationship(beverage = licor))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val naranjuMentolado = Recipe(name = "Naranju menta & picante", description = "Un trago con un toque cítrico y un final picante.", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/fernetnaranja.jpg")
            naranjuMentolado.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            naranjuMentolado.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            naranjuMentolado.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            naranjuMentolado.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val vinoEspeciado = Recipe(name ="Vino especiado", description = "Un viaje nordico" , imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/vinoespeciado.jpg" )
            vinoEspeciado.beverages.add(RecipeBeverageRelationship(beverage = vino))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = hibiscus))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))

            val ganciaPepinada = Recipe(name ="Pepinada", description = "Un trago fresco y ligero, perfecto para cualquier ocasión" , imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/pepinada.jpg")
            ganciaPepinada.beverages.add(RecipeBeverageRelationship(beverage = gancia))
            ganciaPepinada.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))
            ganciaPepinada.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            ganciaPepinada.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mojito = Recipe(name = "Mojito", description = "From Cuba with love", imagePath = "https://github.com/UnderABloodySky/bacco-backend/blob/dev/assets/imgs/recipe/mojito4.jpg")
            mojito.beverages.add(RecipeBeverageRelationship(beverage = ron))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val recipes = listOf(soloAperitivo, aperitivoCervezaYFernet, aperitivoYCerveza,
                fernandito, ginTonic, cubaLibre, cosaRara, cosaFea, michelada, fernetPomelo, ganciaFrutillaMenta, ronLimonado, tintillo, whiskeyGinger, licorMenta, naranjuMentolado, vinoEspeciado, ganciaPepinada, mojito)

            recipeRepository.saveAll(recipes)

            val user0 = User(name = "HValenzuela", password="12345678", email="")
            val user1 = User(name = "fedecame", password="12345678", email="")
            val user2 = User(name = "test", password="12345678", email="")
            val users = listOf(user0, user1, user2)

            userRepository.saveAll(users)
        }
        println("END POPULATION OF DB")
    }

    fun clearDatabase() {
        println("START CLEAR DATABASE")
        recipeRepository.deleteAll()
        beverageRepository.deleteAll()
        ingredientRepository.deleteAll()
        userRepository.deleteAll()
        commentRepository.deleteAll()
        ratingRepository.deleteAll()
        println("END CLEAR DATABASE")
    }
}
