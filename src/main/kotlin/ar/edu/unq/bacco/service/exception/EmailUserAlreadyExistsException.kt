package ar.edu.unq.bacco.service.exception

class EmailUserAlreadyExistsException(email: String) : RuntimeException("User with email $email already exists")
