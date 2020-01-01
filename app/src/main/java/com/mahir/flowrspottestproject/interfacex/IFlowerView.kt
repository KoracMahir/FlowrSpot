package com.mahir.flowrspottestproject.interfacex

import android.view.View
import com.mahir.flowrspottestproject.model.Flower

interface IFlowerView {
    fun getFlowers(flowers: List<Flower>)
    fun getFlowerSearch(searchFlowers:List<Flower>)
    fun onDataFailiure(throwable: Throwable)
    fun moveProgressBar()
    fun showProgressBar()
}