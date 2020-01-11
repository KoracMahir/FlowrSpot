package com.mahir.flowrspottestproject.model

data class Flower(
    val favorite: String,
    val id: String,
    val latin_name: String,
    val name: String,
    val profile_picture: String,
    val sightings: Int,
    val description:String
)