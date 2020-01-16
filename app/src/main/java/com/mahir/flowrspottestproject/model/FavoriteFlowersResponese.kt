package com.mahir.flowrspottestproject.model.FavoriteFlower

import com.mahir.flowrspottestproject.model.Flower

data class FavoriteFlowersResponese(
    val flower: Flower,
    val id: Int,
    val user_id: Int
)