package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.repository.BeverageRepository
import org.springframework.stereotype.Service

@Service
class BeverageService(private val beverageRepository: BeverageRepository) {

    fun findBeveragesByName(name: String = ""): List<Beverage> {
        return beverageRepository.findByNameContainingIgnoreCase(name)
    }
}