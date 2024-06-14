package ar.edu.unq.bacco.service.interfaces

import ar.edu.unq.bacco.model.User

interface UserServiceI {
    fun save(anUser: User): User
    fun findById(id: Long): User?
}