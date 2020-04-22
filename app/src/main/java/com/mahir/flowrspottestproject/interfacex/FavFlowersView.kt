package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese

interface FavFlowersView{
    fun getFavorites(flowers: List<FavoriteFlowersResponese>)
    fun onTokenFailiure()
    fun pBarShow()
    fun pBarHide()
}