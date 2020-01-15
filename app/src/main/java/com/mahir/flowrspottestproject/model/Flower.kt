package com.mahir.flowrspottestproject.model

data class Flower(
    var favorite: Boolean = false,
    val id: String,
    val latin_name: String,
    val name: String,
    val profile_picture: String,
    val sightings: Int,
    val description:String,
    val user_id: Int
)