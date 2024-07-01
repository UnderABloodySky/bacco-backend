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
            val description = "“Ebis vendae eaqui solupta turera prepe paron ut estron, cus as nient aut aut pa nost, consed ut reroribus ex ea dolor as secestron qui con preprae sequam ipsaeperon is ipsamus aectibustior accae perovit quas as modipsunt ut volorro beatemolenis veremporon quianda perchil es quam eum"

            val fernet = Beverage(name = "FERNET", description = "El sabor auténtico de Cordoba y Argentina", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/fernet.jpg")
            val aguaTonica = Beverage(name = "TONICA", description = "Refrescante y versátil", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/aguatonica.jpg")
            val cocaCola = Beverage(name = "COCACOLA", description = "La chispa que necesitas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/cocacola.jpg")
            val gin = Beverage(name = "GIN", description = "La chispa que necesitas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/gin.jpg")
            val ron = Beverage(name = "RON", description = "Una aventura caribeña en tu vaso", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/ron.jpg")
            val licor = Beverage(name = "LICOR", description = "Dulce tentación en cada gota", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/licor.jpg")
            val gancia = Beverage(name="GANCIA", description = "El espíritu italiano en tu copa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/beverage.jpg")
            val whiskey = Beverage(name="WHISKEY", description = "Destilado de distinción y carácter", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/whiskey.jpg")
            val vino = Beverage(name="VINO", description = "Elegancia embotellada", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/vino.jpg")
            val tequila = Beverage(name="TEQUILA", description = "De Mexico para el mundo, manito", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/tequila.jpg")
            val sprite = Beverage(name="SPRITE", description = "Citrica, burbujeante, fresca", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/beverage/sprite.jpg")
            
            val beverages = listOf(tequila, fernet, aguaTonica, cocaCola, gin, ron, licor, gancia, whiskey, vino)

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
            val frutilla = Ingredient(name = "FRUTILLA", description = "Dulzura jugosa y deliciosa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/frutillas.jpg")
            val arandanos = Ingredient(name = "ARANDANOS", description = "Antioxidante natural y exquisito sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/arandanos.jpg")
            val frutosRojos = Ingredient(name = "FRUTOS ROJOS", description = "Vibrante y lleno de sabor", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/frutosrojos.jpg")
            val aceitunas = Ingredient(name = "ACEITUNAS", description = "Toque mediterráneo de autenticidad", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/aceitunas.jpg")
            val hibiscus = Ingredient(name = "HIBISCUS", description = "Roja como la sangre", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/hibiscus.jpg")
            val coco = Ingredient(name = "COCO", description = "Exotico y cremoso", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/coco.jpg")
            val albahaca = Ingredient(name = "ALBAHACA", description = "Aroma garantizado", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/albahaca.jpg")
            val romero = Ingredient(name = "ROMERO", description = "Sabor garantizado", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/romero.jpg")
            val cerezas = Ingredient(name = "CEREZAS", description = "Una bomba de dulzura", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/cerezas.jpg")
            val manzana = Ingredient(name = "MANZANA", description = "Adan, Eva, esta fruta, vos y yo... Pensalo", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/manzana.jpg")
            val pera = Ingredient(name = "PERA", description = "Pura pulpa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/pera.jpg")
            val durazno = Ingredient(name = "PERA", description = "La fruta favorita de Spinetta, cuak!", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/durazno.jpg")
            val uvas = Ingredient(name = "UVAS", description = "De ahi sale el vino, que fruta noble!", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/uvas.jpg")
            val maracuya = Ingredient(name = "MARACUYA", description = "Un viaje a Centroamerica en cada fruteria", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/maracuya.jpg")
            val kiwi = Ingredient(name = "KIWI", description = "Aguantate la pelusa", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/kiwi.jpg")
            val sandia = Ingredient(name = "SANDIA", description = "Una de las pocas cosas buenas del verano", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/sandia.jpg")
            val banana = Ingredient(name = "BANANA", description = "De Ecuador al mundo", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/ingredient/banana.jpg")

            val ingredients = listOf(durazno, uvas, maracuya, kiwi, sandia, banana, albahaca, romero, azucar, cerezas, limon, manzana, pera, coco, pimienta, hielo, sal, leche, azucar, menta, jengibre, pomelo, limon, naranja, pepino, frutilla, aceitunas, frutosRojos, arandanos, hibiscus)

            ingredientRepository.saveAll(ingredients)

            val fernandito = Recipe(name = "Fernandito", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/fernet.jpg")
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernandito.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            fernandito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ginTonic = Recipe(name = "Gin & Tonic", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/gintonic.jpg")
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            ginTonic.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))

            val cubaLibre = Recipe(name = "Cuba Libre", description = description, imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe.jpg")
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = cocaCola))
            cubaLibre.beverages.add(RecipeBeverageRelationship(beverage = ron))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            cubaLibre.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val fernetPomelo = Recipe(name = "Fernet Pomelo", description = "Un trago refrescante y amargo, ideal para una tarde de verano", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/fernetPomelo.jpg")
            fernetPomelo.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernetPomelo.ingredients.add(RecipeIngredientRelationship(ingredient = pomelo))
            fernetPomelo.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ganciaFrutillaMenta = Recipe(name = "Gancia Frutilla mentolada", description = "Una combinación dulce y refrescante con un toque de menta", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/ganciaFrutilla.jpg")
            ganciaFrutillaMenta.beverages.add(RecipeBeverageRelationship(beverage = gancia))
            ganciaFrutillaMenta.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            ganciaFrutillaMenta.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            ganciaFrutillaMenta.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ronLimonado = Recipe(name = "Ron Limonado", description = "Un clásico ron con un toque cítrico y refrescante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_34.jpg")
            ronLimonado.beverages.add(RecipeBeverageRelationship(beverage = ron))
            ronLimonado.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            ronLimonado.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            ronLimonado.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val tintillo = Recipe(name = "Tintillo de verano con Frutos Rojos", description = "Un trago elegante con la mezcla perfecta de vino tinto y frutas", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/tintillo.jpg")
            tintillo.beverages.add(RecipeBeverageRelationship(beverage = vino))
            tintillo.ingredients.add(RecipeIngredientRelationship(ingredient = arandanos))
            tintillo.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            tintillo.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val whiskeyGinger = Recipe(name = "Whiskey Ginger", description = "Un clásico trago con la combinación perfecta de whiskey y jengibre", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/whiskeyginger.jpg")
            whiskeyGinger.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = jengibre))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val licorMenta = Recipe(name = "Licor mentolado", description = "Un trago refrescante y simple, perfecto para una noche relajante", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/licormenta.jpg")
            whiskeyGinger.beverages.add(RecipeBeverageRelationship(beverage = licor))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            whiskeyGinger.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val naranjuMentolado = Recipe(name = "Naranju menta & picante", description = "Un trago con un toque cítrico y un final picante.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_7.jpg")
            naranjuMentolado.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            naranjuMentolado.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            naranjuMentolado.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            naranjuMentolado.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val vinoEspeciado = Recipe(name ="Vino especiado", description = "Un viaje nordico" , imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/vinoespeciado.jpg" )
            vinoEspeciado.beverages.add(RecipeBeverageRelationship(beverage = vino))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = hibiscus))
            vinoEspeciado.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))

            val ganciaPepinada = Recipe(name ="Pepinada", description = "Un trago fresco y ligero, perfecto para cualquier ocasión" , imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_6.jpg")
            ganciaPepinada.beverages.add(RecipeBeverageRelationship(beverage = gancia))
            ganciaPepinada.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))
            ganciaPepinada.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            ganciaPepinada.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mojito = Recipe(name = "Mojito", description = "From Cuba with love", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_.jpg")
            mojito.beverages.add(RecipeBeverageRelationship(beverage = ron))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            mojito.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val pinkGinTonic = Recipe(name = "Pink Gin Tonic", description = "Elegancia y un toque de dulzura.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_35.jpg")
            pinkGinTonic.beverages.add(RecipeBeverageRelationship(beverage = gin))
            pinkGinTonic.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            pinkGinTonic.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            pinkGinTonic.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val coconutron = Recipe(name = "Coconut ron", description = "Una experiencia tropical en cada trago.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_36.jpg")
            coconutron.beverages.add(RecipeBeverageRelationship(beverage = ron))
            coconutron.ingredients.add(RecipeIngredientRelationship(ingredient = leche))
            coconutron.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            coconutron.ingredients.add(RecipeIngredientRelationship(ingredient = coco))
            coconutron.ingredients.add(RecipeIngredientRelationship(ingredient = pomelo))

            val ganciaSpritz = Recipe(name = "Gancia Spritz", description = "El toque italiano refrescante y burbujeante.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_37.jpg")
            ganciaSpritz.beverages.add(RecipeBeverageRelationship(beverage = gancia))
            ganciaSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            ganciaSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            ganciaSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))

            val whiskeySour = Recipe(name = "Whiskey Sour", description = "Una mezcla perfecta de acidez y dulzura.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_38.jpg")
            whiskeySour.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            whiskeySour.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            whiskeySour.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            whiskeySour.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mintWhiskey = Recipe(name = "Mint Whiskey", description = "Refrescante y lleno de carácter.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_39.jpg")
            mintWhiskey.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            mintWhiskey.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mintWhiskey.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val vinoTintoSpritz = Recipe(name = "Vino Tinto Spritz", description = "Un toque espumoso y refrescante al vino tinto.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_40.jpg")
            vinoTintoSpritz.beverages.add(RecipeBeverageRelationship(beverage = vino))
            vinoTintoSpritz.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            vinoTintoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            vinoTintoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))

            val spicyRedWine = Recipe(name = "Spicy Red Wine", description = "Un toque picante para el clásico vino tinto.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_41.jpg")
            spicyRedWine.beverages.add(RecipeBeverageRelationship(beverage = vino))
            spicyRedWine.ingredients.add(RecipeIngredientRelationship(ingredient = pimienta))
            spicyRedWine.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            spicyRedWine.ingredients.add(RecipeIngredientRelationship(ingredient = limon))

            val ginAndMenta = Recipe(name = "Gin & Menta", description = "Un trago revitalizante y fresco.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_42.jpg")
            ginAndMenta.beverages.add(RecipeBeverageRelationship(beverage = gin))
            ginAndMenta.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            ginAndMenta.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val gingerGinFizz = Recipe(name = "Ginger Gin Fizz", description = "Una explosión de sabores cítricos y picantes.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_43.jpg")
            gingerGinFizz.beverages.add(RecipeBeverageRelationship(beverage = gin))
            gingerGinFizz.ingredients.add(RecipeIngredientRelationship(ingredient = jengibre))
            gingerGinFizz.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            gingerGinFizz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val ronAndBerries = Recipe(name = "ron & Berries", description = "Dulzura y frescura en un solo trago.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_44.jpg")
            ronAndBerries.beverages.add(RecipeBeverageRelationship(beverage = ron))
            ronAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = frutosRojos))
            ronAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val licorDeNaranja = Recipe(name = "Licor de Naranja", description = "El dulce encanto de la naranja.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_45.jpg")
            licorDeNaranja.beverages.add(RecipeBeverageRelationship(beverage = licor))
            licorDeNaranja.ingredients.add(RecipeIngredientRelationship(ingredient = naranja))
            licorDeNaranja.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val fernetJengibre = Recipe(name = "Fernet Ginger", description = "Un trago con un toque de picante.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_46.jpg")
            fernetJengibre.beverages.add(RecipeBeverageRelationship(beverage = fernet))
            fernetJengibre.ingredients.add(RecipeIngredientRelationship(ingredient = jengibre))
            fernetJengibre.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val whiskeyAndBerries = Recipe(name = "Whiskey & Berries", description = "Una mezcla de carácter y dulzura.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_47.jpg")
            whiskeyAndBerries.beverages.add(RecipeBeverageRelationship(beverage = whiskey))
            whiskeyAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = frutosRojos))
            whiskeyAndBerries.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val vinoSpritz = Recipe(name = "Vino Spritz", description = "El vino en su versión más refrescante.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_48.jpg")
            vinoSpritz.beverages.add(RecipeBeverageRelationship(beverage = vino))
            vinoSpritz.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            vinoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))
            vinoSpritz.ingredients.add(RecipeIngredientRelationship(ingredient = pomelo))

            val cucumberGin = Recipe(name = "Cucumber Gin", description = "Ligero y refrescante, perfecto para el verano.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_49.jpg")
            cucumberGin.beverages.add(RecipeBeverageRelationship(beverage = gin))
            cucumberGin.ingredients.add(RecipeIngredientRelationship(ingredient = pepino))
            cucumberGin.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))


            val margaritaDurazno = Recipe(name = "Margarita de Durazno", description = "Una margarita con el sabor dulce del durazno fresco.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_50.jpg")
            margaritaDurazno.beverages.add(RecipeBeverageRelationship(beverage = tequila))
            margaritaDurazno.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            margaritaDurazno.ingredients.add(RecipeIngredientRelationship(ingredient = durazno))
            margaritaDurazno.ingredients.add(RecipeIngredientRelationship(ingredient = sal))
            margaritaDurazno.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val margaritaFresa = Recipe(name = "Margarita de Fresa", description = "Una margarita con el sabor dulce y jugoso de las fresas frescas.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_51.jpg")
            margaritaFresa.beverages.add(RecipeBeverageRelationship(beverage = tequila))
            margaritaFresa.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            margaritaFresa.ingredients.add(RecipeIngredientRelationship(ingredient = frutilla))
            margaritaFresa.ingredients.add(RecipeIngredientRelationship(ingredient = sal))
            margaritaFresa.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val margaritaCereza = Recipe(name = "Margarita de Cereza", description = "Una margarita con el sabor dulce y ácido de las cerezas frescas.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_52.jpg")
            margaritaCereza.beverages.add(RecipeBeverageRelationship(beverage = tequila))
            margaritaCereza.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            margaritaCereza.ingredients.add(RecipeIngredientRelationship(ingredient = cerezas))
            margaritaCereza.ingredients.add(RecipeIngredientRelationship(ingredient = sal))
            margaritaCereza.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val margaritaFrutasTropicales = Recipe(name = "Margarita de Frutas Tropicales", description = "Una margarita con una mezcla de frutas tropicales para un sabor exótico y refrescante.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_53.jpg")
            margaritaFrutasTropicales.beverages.add(RecipeBeverageRelationship(beverage = tequila))
            margaritaFrutasTropicales.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            margaritaFrutasTropicales.ingredients.add(RecipeIngredientRelationship(ingredient = kiwi))
            margaritaFrutasTropicales.ingredients.add(RecipeIngredientRelationship(ingredient = maracuya))
            margaritaFrutasTropicales.ingredients.add(RecipeIngredientRelationship(ingredient = sal))
            margaritaFrutasTropicales.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val margaritaCoco = Recipe(name = "Margarita de Coco", description = "Una margarita con el sabor tropical y cremoso del coco fresco.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_54.jpg")
            margaritaCoco.beverages.add(RecipeBeverageRelationship(beverage = tequila))
            margaritaCoco.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            margaritaCoco.ingredients.add(RecipeIngredientRelationship(ingredient = coco))
            margaritaCoco.ingredients.add(RecipeIngredientRelationship(ingredient = sal))
            margaritaCoco.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val margaritaSandia = Recipe(name = "Margarita de Sandía", description = "Una margarita refrescante con el dulce sabor de la sandía fresca.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_55.jpg")
            margaritaSandia.beverages.add(RecipeBeverageRelationship(beverage = tequila))
            margaritaSandia.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            margaritaSandia.ingredients.add(RecipeIngredientRelationship(ingredient = sandia))
            margaritaSandia.ingredients.add(RecipeIngredientRelationship(ingredient = sal))
            margaritaSandia.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val daiquiriSandia = Recipe(name = "Daiquiri de Sandía", description = "Un daiquiri refrescante con el sabor dulce y jugoso de la sandía.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_56.jpg")
            daiquiriSandia.beverages.add(RecipeBeverageRelationship(beverage = ron))
            daiquiriSandia.beverages.add(RecipeBeverageRelationship(beverage = sprite))
            daiquiriSandia.ingredients.add(RecipeIngredientRelationship(ingredient = sandia))
            daiquiriSandia.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            daiquiriSandia.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val daiquiriCereza = Recipe(name = "Daiquiri de Cereza", description = "Un daiquiri con el sabor dulce y ácido de las cerezas frescas.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_57.jpg")
            daiquiriCereza.beverages.add(RecipeBeverageRelationship(beverage = ron))
            daiquiriCereza.beverages.add(RecipeBeverageRelationship(beverage = sprite))
            daiquiriCereza.ingredients.add(RecipeIngredientRelationship(ingredient = cerezas))
            daiquiriCereza.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            daiquiriCereza.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val daiquirimanzana = Recipe(name = "Daiquiri de Fruta de la Pasión", description = "Un daiquiri con el sabor exótico y ácido de la fruta de la pasión.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_58.jpg")
            daiquirimanzana.beverages.add(RecipeBeverageRelationship(beverage = ron))
            daiquirimanzana.beverages.add(RecipeBeverageRelationship(beverage = sprite))
            daiquirimanzana.ingredients.add(RecipeIngredientRelationship(ingredient = manzana))
            daiquirimanzana.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            daiquirimanzana.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mojitomanzana = Recipe(name = "Mojito de Fruta de la Pasión", description = "Un mojito con el sabor exótico y refrescante de la fruta de la pasión.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_59.jpg")
            mojitomanzana.beverages.add(RecipeBeverageRelationship(beverage = ron))
            mojitomanzana.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            mojitomanzana.ingredients.add(RecipeIngredientRelationship(ingredient = manzana))
            mojitomanzana.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            mojitomanzana.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mojitomanzana.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            mojitomanzana.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mojitoSandia = Recipe(name = "Mojito de Sandía", description = "Un mojito con el sabor refrescante y dulce de la sandía fresca.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_60.jpg")
            mojitoSandia.beverages.add(RecipeBeverageRelationship(beverage = ron))
            mojitoSandia.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            mojitoSandia.ingredients.add(RecipeIngredientRelationship(ingredient = sandia))
            mojitoSandia.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            mojitoSandia.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mojitoSandia.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            mojitoSandia.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val daiquiribanana = Recipe(name = "Daiquiri de Plátano", description = "Un daiquiri con el sabor dulce y cremoso del plátano.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_61.jpg")
            daiquiribanana.beverages.add(RecipeBeverageRelationship(beverage = ron))
            daiquiribanana.beverages.add(RecipeBeverageRelationship(beverage = sprite))
            daiquiribanana.ingredients.add(RecipeIngredientRelationship(ingredient = banana))
            daiquiribanana.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            daiquiribanana.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val mojitoUva = Recipe(name = "Mojito de Uva", description = "Un mojito con el sabor dulce y jugoso de las uvas frescas.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_62.jpg")
            mojitoUva.beverages.add(RecipeBeverageRelationship(beverage = ron))
            mojitoUva.beverages.add(RecipeBeverageRelationship(beverage = aguaTonica))
            mojitoUva.ingredients.add(RecipeIngredientRelationship(ingredient = uvas))
            mojitoUva.ingredients.add(RecipeIngredientRelationship(ingredient = limon))
            mojitoUva.ingredients.add(RecipeIngredientRelationship(ingredient = menta))
            mojitoUva.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            mojitoUva.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))

            val daiquiriUva = Recipe(name = "Daiquiri de Uva", description = "Un daiquiri con el sabor dulce y jugoso de las uvas frescas.", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_63.jpg")
            daiquiriUva.beverages.add(RecipeBeverageRelationship(beverage = ron))
            daiquiriUva.beverages.add(RecipeBeverageRelationship(beverage = sprite))
            daiquiriUva.ingredients.add(RecipeIngredientRelationship(ingredient = uvas))
            daiquiriUva.ingredients.add(RecipeIngredientRelationship(ingredient = azucar))
            daiquiriUva.ingredients.add(RecipeIngredientRelationship(ingredient = hielo))


            val test = Recipe(name = "TEST", description = "TEST", imagePath = "https://raw.githubusercontent.com/UnderABloodySky/bacco-backend/dev/assets/imgs/recipe/recipe_62.jpg")
            for(ing in ingredients){
                test.ingredients.add(RecipeIngredientRelationship(ingredient = ing))
            }

            for(bev in beverages){
                test.beverages.add(RecipeBeverageRelationship(beverage = bev))
            }

            val recipes = listOf(test, mojitomanzana, daiquirimanzana, daiquiriCereza, daiquiriSandia, margaritaSandia, margaritaCoco, margaritaFrutasTropicales, margaritaCereza, margaritaFresa, margaritaDurazno, mojitoSandia, daiquiribanana, mojitoUva, daiquiriUva, pinkGinTonic, fernandito, ginTonic, cubaLibre, fernetPomelo, ganciaFrutillaMenta, ronLimonado, tintillo, whiskeyGinger, licorMenta, naranjuMentolado, vinoEspeciado, ganciaPepinada, mojito)

            recipeRepository.saveAll(recipes)

            val user0 = User(name = "hvalenzuela", password="12345678", email="valenzuelahoracioe@gmail.com")
            val user1 = User(name = "fedecame", password="12345678", email="fedecame@gmail.com")
            val user2 = User(name = "test1234", password="12345678", email="test@bacco.com")
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
