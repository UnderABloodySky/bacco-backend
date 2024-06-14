package ar.edu.unq.bacco.service

import ar.edu.unq.bacco.model.Ingredient
import ar.edu.unq.bacco.repository.IngredientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class IngredientService @Autowired constructor (private var ingredientRepository: IngredientRepository)  {
    fun findIngredientsByName(name: String = ""): List<Ingredient> {
        return ingredientRepository.findByNameContainingIgnoreCase(name)
    }
}