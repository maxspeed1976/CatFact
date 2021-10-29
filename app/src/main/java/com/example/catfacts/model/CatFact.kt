package com.example.catfacts.model

//data class CatFactResult(val items: List<CatFact>)



data class Links (

    val url : String,
    val label : String,
    val active : Boolean
)

data class Data (

    val fact : String,
    val length : Int
)
data class CatResult (

    val current_page : Int,
    val data : List<Data>,
    val first_page_url : String,
    val from : Int,
    val last_page : Int,
    val last_page_url : String,
    val links : List<Links>,
    val next_page_url : String,
    val path : String,
    val per_page : Int,
    val prev_page_url : String,
    val to : Int,
    val total : Int
)