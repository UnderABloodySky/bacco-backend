package ar.edu.unq.bacco.service.interfaces

import ar.edu.unq.bacco.model.enums.Beverage


interface BeverageServiceI {
    fun findBeveragesByName(name: String = ""): List<Beverage>
}