package ar.edu.unq.bacco.service
import ar.edu.unq.bacco.model.User
import ar.edu.unq.bacco.repository.UserRepository
import ar.edu.unq.bacco.service.interfaces.UserServiceI
import org.springframework.stereotype.Service

@Service

class UserService(private val anUserRepository: UserRepository) : UserServiceI {

    override fun save(anUser: User): User {
        return anUserRepository.save(anUser)
    }

    override fun findById(id: Long): User? {
        return anUserRepository.findById(id).orElse(null)
    }
}
