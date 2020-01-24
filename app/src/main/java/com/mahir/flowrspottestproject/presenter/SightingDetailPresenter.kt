package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.SightingDetailView
import com.mahir.flowrspottestproject.model.Comment
import com.mahir.flowrspottestproject.model.CommentsResponse
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import com.mahir.flowrspottestproject.model.sightingmodels.SightingModel
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SightingDetailPresenter(sightingDetailView: SightingDetailView) {
    val sightingDetailView = sightingDetailView

    fun getComments(sightingId:Int){
        RetrofitServices.create()
            .getComments(sightingId)
            .enqueue(object: Callback<CommentsResponse>{
                override fun onResponse(call: Call<CommentsResponse>, response: Response<CommentsResponse>) {
                    sightingDetailView.getComments(response.body()?.comments as List<Comment>)
                }

                override fun onFailure(call: Call<CommentsResponse>, t: Throwable) {

                }

            })
    }
    fun getDetails(sightingId:Int){
        RetrofitServices.create()
            .getSightingDetails(sightingId)
            .enqueue(object : Callback<SightingModel>{
                override fun onResponse(call: Call<SightingModel>, response: Response<SightingModel>) {
                    sightingDetailView.getDetails(response.body()?.sighting as Sighting)
                }
                override fun onFailure(call: Call<SightingModel>, t: Throwable) {

                }
            })
    }
}