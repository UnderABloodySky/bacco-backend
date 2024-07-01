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
            val aguaTonica = Beverage(name = "TONICA", description = "Refrescante y versátil", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/aguatonica.jpg")
            val cocaCola = Beverage(name = "COCACOLA", description = "La chispa que necesitas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/cocacola.jpg")
            val gin = Beverage(name = "GIN", description = "La chispa que necesitas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/gin.jpg")
            val ron = Beverage(name = "RON", description = "Una aventura caribeña en tu vaso", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/ron.jpg")
            val licor = Beverage(name = "LICOR", description = "Dulce tentación en cada gota", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/licor.jpg")
            val gancia = Beverage(name="GANCIA", description = "El espíritu italiano en tu copa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val whiskey = Beverage(name="WHISKEY", description = "Destilado de distinción y carácter", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/whiskey.jpg")
            val vino = Beverage(name="VINO", description = "Elegancia embotellada", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/vino.jpg")
            val beverages = listOf(fernet, aguaTonica, cocaCola, gin, ron, licor, gancia, whiskey, vino)

            beverageRepository.saveAll(beverages)

            val pimienta = Ingredient(name = "PIMIENTA", description = "Toque de intensidad y sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/pimienta.jpg")
            val hielo = Ingredient(name = "HIELO", description = "Mas frio que el corazon de tu ex", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/hielo.jpg")
            val sal = Ingredient(name = "SAL", description = "Equilibrio perfecto para tu paladar", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/sal.jpg")
            val leche = Ingredient(name = "LECHE", description = "Suavidad inigualable en cada trago", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/leche.jpg")
            val azucar = Ingredient(name = "AZUCAR", description = "Dulzura exquisita para deleitar tus sentidos", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/azucar.jpg")
            val menta = Ingredient(name = "MENTA", description = "Frescor natural y refrescante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/menta.jpg")
            val jengibre = Ingredient(name = "JENGIBRE", description = "Toque picante y revitalizante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/jengibre.jpg")
            val pomelo = Ingredient(name = "POMELO", description = "Refrescante y lleno de vitalidad", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/pomelo.jpg")
            val limon = Ingredient(name = "LIMON", description = "Acidez refrescante y cítrica", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/limon.jpg")
            val naranja = Ingredient(name = "NARANJA", description = "Dulzura cítrica y energizante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/naranja.jpg")
            val pepino = Ingredient(name = "PEPINO", description = "Refrescante y crujiente", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/pepino.jpg")
            val frutilla = Ingredient(name = "FRUTILLA", description = "Dulzura jugosa y deliciosa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/frutilla.jpg")
            val arandanos = Ingredient(name = "ARANDANOS", description = "Antioxidante natural y exquisito sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/arandanos.jpg")
            val frutosRojos = Ingredient(name = "FRUTOS ROJOS", description = "Vibrante y lleno de sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/frutosrojos.jpg")
            val aceitunas = Ingredient(name = "ACEITUNAS", description = "Toque mediterráneo de autenticidad", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/aceitunas.jpg")
            val hibiscus = Ingredient(name = "HIBISCUS", description = "Roja como la sangre", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/hibiscus.jpg")
            val coco = Ingredient(name = "COCO", description = "Exotico y cremoso", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/coco.jpg")
            val albahaca = Ingredient(name = "ALBAHACA", description = "Aroma garantizado", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/albahaca.jpg")
            val romero = Ingredient(name = "ROMERO", description = "Sabor garantizado", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/romero.jpg")
            val azucar = Ingredient(name = "AZUCAR", description = "Dulzura garantizada", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/azucar.jpg")
            val cerezas = Ingredient(name = "CEREZAS", description = "Una bomba de dulzura", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/cerezas.jpg")
            val limon = Ingredient(name = "LIMON", description = "Citrico, fresco", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/limon.jpg")
            val manzana = Ingredient(name = "MANZANA", description = "Adan, Eva, esta fruta, vos y yo... Pensalo", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/manzana.jpg")
            val pera = Ingredient(name = "PERA", description = "Pura pulpa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/pera.jpg")


            val ingredients = listOf(coco, pimienta, hielo, sal, leche, azucar, menta, jengibre, pomelo, limon, naranja, pepino, frutilla, aceitunas, frutosRojos, arandanos, hibiscus)

            ingredientRepository.saveAll(ingredients)

            val fernandito = Recipe(name = "Fernet", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/fernet.jpg")
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            fernandito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ginTonic = Recipe(name = "Gin & Tonic", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))

            val cubaLibre = Recipe(name = "Cuba Libre", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

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

            val pinkGinTonic = Recipe(name = "Pink Gin Tonic", description = "Elegancia y un toque de dulzura.", imagePath = "")
            pinkGinTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            pinkGinTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            pinkGinTonic.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            pinkGinTonic.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val coconutRum = Recipe(name = "Coconut Rum", description = "Una experiencia tropical en cada trago.", imagePath = "")
            coconutRum.beverages.add(RecipeBeverageRelationship(beverage = ron))
            coconutRum.ingredients.add(RecipeIngredientRelationship(ingredient = leche))
            coconutRum.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            coconutRum.ingredients.add(RecipeIngredientRelationship(ingredient = coco))
            coconutRum.ingredients.add(RecipeIngredientRelationship(ingredient = pomelo))

            val ganciaSpritz = Recipe(name = "Gancia Spritz", description = "El toque italiano refrescante y burbujeante.", imagePath = "")
            ganciaSpritz.beverages.add(RecipeBeverageRelationship(beverage = gancia))
            ganciaSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            ganciaSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            ganciaSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))

            val whiskeySour = Recipe(name = "Whiskey Sour", description = "Una mezcla perfecta de acidez y dulzura.", imagePath = "")
            whiskeySour.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            whiskeySour.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            whiskeySour.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            whiskeySour.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mintWhiskey = Recipe(name = "Mint Whiskey", description = "Refrescante y lleno de carácter.", imagePath = "")
            mintWhiskey.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            mintWhiskey.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mintWhiskey.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val vinoTintoSpritz = Recipe(name = "Vino Tinto Spritz", description = "Un toque espumoso y refrescante al vino tinto.", imagePath = "")
            vinoTintoSpritz.beverages.add(RecipeBeverageRelationship(beverage = vino))
            vinoTintoSpritz.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            vinoTintoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            vinoTintoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))

            val spicyRedWine = Recipe(name = "Spicy Red Wine", description = "Un toque picante para el clásico vino tinto.", imagePath = "")
            spicyRedWine.beverages.add(RecipeBeverageRelationship(beverage = vino))
            spicyRedWine.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            spicyRedWine.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            spicyRedWine.ingredients.add(RecipeIngredientRelationship(ingredient = limon))

            val ginAndMenta = Recipe(name = "Gin & Menta", description = "Un trago revitalizante y fresco.", imagePath = "")
            ginAndMenta.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginAndMenta.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            ginAndMenta.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val gingerGinFizz = Recipe(name = "Ginger Gin Fizz", description = "Una explosión de sabores cítricos y picantes.", imagePath = "")
            gingerGinFizz.beverages.add(RecipeBeverageRelationship(beverage = gin))
            gingerGinFizz.ingredients.add(RecipeIngredientRelationship(ingredient = jengibre))
            gingerGinFizz.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            gingerGinFizz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val rumAndBerries = Recipe(name = "Rum & Berries", description = "Dulzura y frescura en un solo trago.", imagePath = "")
            rumAndBerries.beverages.add(RecipeBeverageRelationship(beverage = ron))
            rumAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = frutosRojos))
            rumAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val licorDeNaranja = Recipe(name = "Licor de Naranja", description = "El dulce encanto de la naranja.", imagePath = "")
            licorDeNaranja.beverages.add(RecipeBeverageRelationship(beverage = licor))
            licorDeNaranja.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))
            licorDeNaranja.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val fernetJengibre = Recipe(name = "Fernet Ginger", description = "Un trago con un toque de picante.", imagePath = "")
            fernetJengibre.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernetJengibre.ingredients.add(RecipeIngredientRelationship(ingredient = jengibre))
            fernetJengibre.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val whiskeyAndBerries = Recipe(name = "Whiskey & Berries", description = "Una mezcla de carácter y dulzura.", imagePath = "")
            whiskeyAndBerries.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            whiskeyAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = frutosRojos))
            whiskeyAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val vinoSpritz = Recipe(name = "Vino Spritz", description = "El vino en su versión más refrescante.", imagePath = "")
            vinoSpritz.beverages.add(RecipeBeverageRelationship(beverage = vino))
            vinoSpritz.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            vinoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            vinoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = pomelo))

            val cucumberGin = Recipe(name = "Cucumber Gin", description = "Ligero y refrescante, perfecto para el verano.", imagePath = "")
            cucumberGin.beverages.add(RecipeBeverageRelationship(beverage = gin))
            cucumberGin.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))
            cucumberGin.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))



            val recipes = listOf(pinkGinTonic, fernandito, ginTonic, cubaLibre, fernetPomelo, ganciaFrutillaMenta, ronLimonado, tintillo, whiskeyGinger, licorMenta, naranjuMentolado, vinoEspeciado, ganciaPepinada, mojito)

            recipeRepository.saveAll(recipes)

            val user0 = User(name = "hvalenzuela", password="12345678", email="")
            val user1 = User(name = "fedecame", password="12345678", email="")
            val user2 = User(name = "test", password="12345678", email="")
            val users = listOf(user0, user1, user2)

            userRepository.saveAll(users)

            val comment0 = Comment(content = "Lo mejor que me paso este año", user = user0)
            val comment1 = Comment(content = "Por culpa de este trago perdi el pelo", user = user1)
            val comment2 = Comment(content = "Esto es un comentario generico", user = user2)

            val comments = listOf(comment0, comment1, comment2)

            commentRepository.saveAll(comments)

            ginTonic.comments.add(comment0)
            ginTonic.comments.add(comment2)
            fernetPomelo.comments.add(comment1)
            fernetPomelo.comments.add(comment2)

            val rating0 = Rating(user = user0, score = 5.0)
            val rating1 = Rating(user = user1, score = 4.5)
            val rating2 = Rating(user = user2, score = 5.0)
            val rating3 = Rating(user = user0, score = 4.5)
            val rating4 = Rating(user = user1, score = 2.5)

            ginTonic.ratings.add(rating0)
            ginTonic.ratings.add(rating1)

            ginTonic.ratings.add(rating4)
            fernandito.ratings.add(rating3)

            mojito.ratings.add(rating2)

            val ratings = listOf(rating0, rating1, rating2, rating3, rating4)
            ratingRepository.saveAll(ratings)

            val recipesWithRanking = listOf(ginTonic, fernandito, mojito)

            val recipesWithComments = listOf(ginTonic, fernetPomelo)

            recipeRepository.saveAll(recipesWithRanking)
            recipeRepository.saveAll(recipesWithComments)
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
