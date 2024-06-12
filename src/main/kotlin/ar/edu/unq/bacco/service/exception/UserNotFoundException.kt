package ar.edu.unq.bacco.service.exception

class UserNotFoundException(id: Long) : RuntimeException("User with id $id not found") {
}