package com.mahir.flowrspottestproject.model

data class DeleteFavorite(
    val flower: Flower,
    val id: Int,
    val user_id: Int
)