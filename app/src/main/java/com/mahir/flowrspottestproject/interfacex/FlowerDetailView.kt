package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.FlowerX

interface FlowerDetailView{
    fun getFlowerDetails(flowerdetail: FlowerX)
    fun moveProgressBar()
    fun showProgressBar()
}