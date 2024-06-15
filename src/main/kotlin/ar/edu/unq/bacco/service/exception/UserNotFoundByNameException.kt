package ar.edu.unq.bacco.service.exception

class UserNotFoundByNameException(username: String) : RuntimeException("User with name $username not found")
