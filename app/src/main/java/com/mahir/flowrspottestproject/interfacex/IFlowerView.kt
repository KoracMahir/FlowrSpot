package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.Flower

interface IFlowerView {
    fun getFlowers(flowers: List<Flower>)
    fun onDataFailiure(throwable: Throwable)
}