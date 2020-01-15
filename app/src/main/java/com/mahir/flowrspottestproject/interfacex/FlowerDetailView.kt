package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.Flower

interface FlowerDetailView{
    fun getFlowerDetails(flowerdetail: Flower)
    fun moveProgressBar()
    fun showProgressBar()
    fun refreshToken(succerror:Any)
    fun refreshTokenFailed()
}