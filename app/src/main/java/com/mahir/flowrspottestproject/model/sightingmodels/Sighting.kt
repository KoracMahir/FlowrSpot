package com.mahir.flowrspottestproject.model.sightingmodels

data class Sighting(
    val comments_count: Int,
    val created_at: String,
    val description: String,
    val flower: Flower,
    val id: Int,
    val latitude: Double,
    val likes_count: Int,
    val longitude: Double,
    val name: String,
    val picture: String,
    val user: User
)