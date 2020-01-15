package com.mahir.flowrspottestproject.model.FavoriteFlower

import com.mahir.flowrspottestproject.model.Flower

data class FavFlower(
    val flower: Flower,
    val id: Int,
    val user_id: Int
)