package com.mahir.flowrspottestproject.model.FavoriteFlower

import com.mahir.flowrspottestproject.model.Meta

data class FavoriteFlowers(
    val fav_flowers: List<FavFlower>,
    val meta: Meta
)