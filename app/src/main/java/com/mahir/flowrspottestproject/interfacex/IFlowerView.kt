package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.model.Flower

interface IFlowerView{
    fun getFlowers(flowers: List<Flower>)
    fun onDataFailiure(throwable: Throwable)
    fun moveProgressBar()
    fun showProgressBar()
    fun getFavorites(flowers: List<FavoriteFlowersResponese>)
    fun onTokenFailiure()
}