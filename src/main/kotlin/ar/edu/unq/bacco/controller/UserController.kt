package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.DTO.RecipeDTO
import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.model.DTO.LoginDTO
import ar.edu.unq.bacco.service.RecipeService
import ar.edu.unq.bacco.service.UserService
import ar.edu.unq.bacco.service.exception.BeveragesOrIngredientsNullBadRequestException
import ar.edu.unq.bacco.service.exception.UserAlreadyExistsException
import ar.edu.unq.bacco.service.exception.UserNotFoundByNameException
import ar.edu.unq.bacco.service.exception.UserNotFoundException
import jakarta.validation.Valid
import org.apache.http.auth.InvalidCredentialsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController @Autowired constructor (private var anUserService: UserService, private var anRecipeService: RecipeService) {

    @PostMapping
    fun createUser(@RequestBody anUser: User): ResponseEntity<User?> {
        return try{
            val savedUser = anUserService.save(anUser)
            ResponseEntity.status(HttpStatus.CREATED).body(savedUser)
        }
        catch(ex: UserAlreadyExistsException){
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping("/login")
    fun loginUser(@RequestBody request: LoginDTO): ResponseEntity<User?>{
        return try{
            val user = anUserService.loginUser(request.username, request.password)
            ResponseEntity(user, HttpStatus.CREATED)
        }catch(ex: InvalidCredentialsException){
            ResponseEntity.badRequest().body(null)
        }catch(ex: UserNotFoundByNameException){
            ResponseEntity.noContent().build<User?>()
        }
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        return try{
            ResponseEntity.ok(anUserService.findById(id))
        }
        catch(ex:UserNotFoundException){
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping("/recipe/{anID}")
    fun addRecipe(@PathVariable anID: Long, @RequestBody aRecipeDTO: RecipeDTO): ResponseEntity<Recipe> {
        var recipe: Recipe? = null
        return try{
            val user = anUserService.findById(anID)
            recipe = anRecipeService.save(aRecipeDTO, user)
            ResponseEntity(recipe, HttpStatus.CREATED)
        }
        catch (ex: BeveragesOrIngredientsNullBadRequestException) {
            ResponseEntity(recipe, HttpStatus.BAD_REQUEST)
        }
        catch (ex: Exception) {
            ResponseEntity(recipe, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}
