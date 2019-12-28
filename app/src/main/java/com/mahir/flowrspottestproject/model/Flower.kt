package com.mahir.flowrspottestproject.model

data class Flower(
    val favorite: Boolean,
    val id: Int,
    val latin_name: String,
    val name: String,
    val profile_picture: String,
    val sightings: Int
)