package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.model.sightingmodels.FlowerSightingsModel
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting

interface FlowerDetailView{
    fun getFlowerDetails(flowerdetail: Flower)
    fun moveProgressBar()
    fun showProgressBar()
    fun refreshToken(succerror:Any)
    fun refreshTokenFailed()
    fun getFlowerSightings(sightingsList: List<Sighting>)
}