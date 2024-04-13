package ar.edu.unq.bacco.utils

import DetectText

class Mediator {

    fun detectBeverage(filePath: String): String {
        val identifiedTexts = DetectText.detectText(filePath)
        val beverage = identifiedTexts.find { text ->
            Beverages.values().any { it.name == text.uppercase() }
        }
        return beverage ?: "No se encontró ninguna bebida"
    }
}