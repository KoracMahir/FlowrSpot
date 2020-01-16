package com.mahir.flowrspottestproject.model

import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese

data class FlowersResponese(
    val flowers: List<Flower>?,
    val fav_flowers: List<FavoriteFlowersResponese>?,
    val meta: Meta
)