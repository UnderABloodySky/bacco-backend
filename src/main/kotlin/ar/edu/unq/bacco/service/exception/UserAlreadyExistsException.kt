package ar.edu.unq.bacco.service.exception

class UserAlreadyExistsException(username: String) : RuntimeException("User with username $username already exists")
