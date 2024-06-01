package ar.edu.unq.bacco.model

import org.springframework.data.neo4j.core.schema.Node

@Node
class Beverage(
    name: String,
    description: String,
): Ingredient(name=name, description=description)