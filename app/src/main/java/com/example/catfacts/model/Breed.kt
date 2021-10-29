package com.example.catfacts.model

data class BreedResult(val items: List<Breed>)

data class Breed (
    val breed : String,
    val country : String,
    val origin : String,
    val coat : String,
    val pattern : String
)
