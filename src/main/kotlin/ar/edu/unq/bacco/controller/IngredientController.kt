package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Ingredient
import ar.edu.unq.bacco.service.IngredientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ingredients")
class IngredientController @Autowired constructor(private var ingredientService: IngredientService) {
    @GetMapping("/search")
    fun getBeveragesByName(@RequestParam name: String): List<Ingredient> {
        return ingredientService.findIngredientsByName(name)
    }
}