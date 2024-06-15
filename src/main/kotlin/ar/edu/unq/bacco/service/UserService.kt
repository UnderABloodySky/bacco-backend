package ar.edu.unq.bacco.service
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.repository.UserRepository
import ar.edu.unq.bacco.service.exception.*
import ar.edu.unq.bacco.service.interfaces.UserServiceI
import ar.edu.unq.bacco.utils.Validator
import org.apache.http.auth.InvalidCredentialsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class UserService  @Autowired constructor (private var anUserRepository: UserRepository) : UserServiceI {

    override fun save(anUser: User): User {
        val username = anUser.name
        val email = anUser.email
        if (anUserRepository.findByName(username).isPresent) {
            throw UserAlreadyExistsException(username)
        }

        if (anUserRepository.findByEmail(username).isPresent) {
            throw EmailUserAlreadyExistsException(email)
        }

        val user = User(name=username, password=anUser.password, email=email)
        if(Validator().isValidadateUser(user)){
            return anUserRepository.save(anUser)
        }
        else{
            throw UserAlreadyExistsException(username)
        }
    }

    override fun findById(id: Long): User {
        val response = anUserRepository.findById(id)
        if(!response.isPresent){
            throw UserNotFoundException(id)
        }
        return response.get()
    }

    fun loginUser(username: String, password: String): User? {
        val userA = anUserRepository.findByName(username)
        println("PASSWORD: " + userA)

        val user = anUserRepository.findByName(username)
            .orElseThrow { UserNotFoundByNameException(username) }

        println("paswword: " + user.password)
        if (password == user.password) {
            throw InvalidCredentialsException("Invalid password for user $username")
        }
        return user
    }
}
