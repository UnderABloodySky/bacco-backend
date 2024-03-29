package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.User

interface UserService {
    fun save(anUser: User): User
    fun findById(id: Long): User?
}