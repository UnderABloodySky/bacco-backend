package ar.edu.unq.bacco.controller
import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import ar.edu.unq.bacco.service.interfaces.UserServiceI
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController (private val anUserService: UserService, private val anRecipeService: RecipeService) {

    @PostMapping
    fun createUser(@RequestBody anUser: User): ResponseEntity<User> {
        val savedUser = anUserService.save(anUser)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = anUserService.findById(id)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/recipe/{id}")
    fun addRecipe(@PathVariable id: Long, @RequestBody recipe: RecipeDTO): ResponseEntity<Recipe> {
        println(id)
        println(recipe)
        val user = anUserService.findById(id)
        val recipe = anRecipeService.save(recipe, user)
        return ResponseEntity(recipe, HttpStatus.CREATED)

    }


}
