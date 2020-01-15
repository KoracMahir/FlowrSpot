package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.FavoriteFlower.FavFlower
import com.mahir.flowrspottestproject.model.Flower

interface IFlowerView{
    fun getFlowers(flowers: List<Flower>)
    fun onDataFailiure(throwable: Throwable)
    fun moveProgressBar()
    fun showProgressBar()
    fun getFavorites(flowers: List<FavFlower>)
    fun refreshToken(succerror:Any)
    fun refreshTokenFailed()
}