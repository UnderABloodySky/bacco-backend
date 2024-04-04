package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Recipe
import ar.edu.unq.bacco.repository.BeverageRepository
import org.springframework.stereotype.Service

@Service
class BeverageService(private val beverageRepository : BeverageRepository) {
    fun findRecipesByBeverage(aBeverageName: String): List<Recipe> {
        return beverageRepository.findByBeverageName(aBeverageName).toList()
    }
}

