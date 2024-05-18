package ar.edu.unq.bacco.controller

import ar.edu.unq.bacco.model.Beverage
import ar.edu.unq.bacco.service.BeverageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/beverages")
class BeverageController(private val beverageService: BeverageService) {
    @GetMapping("/search")
    fun getBeveragesByName(@RequestParam name: String): List<Beverage> {
        return beverageService.findBeveragesByName(name)
    }
}