package ar.edu.unq.bacco

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BaccoApplication

fun main(args: Array<String>) {
	runApplication<BaccoApplication>(*args)
}
