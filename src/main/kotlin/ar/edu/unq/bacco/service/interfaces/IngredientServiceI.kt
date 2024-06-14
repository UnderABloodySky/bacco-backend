package ar.edu.unq.bacco.service.interfaces

import ar.edu.unq.bacco.model.Ingredient

interface IngredientServiceI {
    fun findIngredientsByName(name: String = ""): List<Ingredient>
}