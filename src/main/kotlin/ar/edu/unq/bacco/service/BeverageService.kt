package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.repository.BeverageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BeverageService(@Autowired private val beverageRepository: BeverageRepository) {

    fun findBeveragesByName(name: String = ""): List<Beverage> {
        return beverageRepository.findByNameContainingIgnoreCase(name)
    }
}