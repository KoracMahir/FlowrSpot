package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.SightingListView
import com.mahir.flowrspottestproject.model.sightingmodels.FlowerSightingsModel
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SightingListPresenter(sightingListView: SightingListView){
    val sightingListView = sightingListView

    fun getSightings(){
        RetrofitServices.create()
            .getSightingList()
            .enqueue(object: Callback<FlowerSightingsModel> {
                override fun onResponse(call: Call<FlowerSightingsModel>, response: Response<FlowerSightingsModel>) {
                    sightingListView.getSightingList(response.body()?.sightings as List<Sighting>)
                }

                override fun onFailure(call: Call<FlowerSightingsModel>, t: Throwable) {

                }
            })
    }
}