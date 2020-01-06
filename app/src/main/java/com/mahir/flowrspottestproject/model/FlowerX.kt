package com.mahir.flowrspottestproject.model

data class FlowerX(
    val description: String,
    val favorite: Boolean,
    val features: List<String>,
    val id: Int,
    val latin_name: String,
    val name: String,
    val profile_picture: String,
    val sightings: Int
)