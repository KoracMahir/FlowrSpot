package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.FlowerDetailView
import com.mahir.flowrspottestproject.model.*
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerDetailPresenter(flowerDetailView: FlowerDetailView){
    val flowerDetailView = flowerDetailView

    fun getFlowerDetail(id:Int){
        flowerDetailView.showProgressBar()
        RetrofitServices.create()
            .getFlowerDetailApi(id)
            .enqueue(object : Callback<FlowerDetail> {
                override fun onFailure(call: Call<FlowerDetail>, t: Throwable) {
                    flowerDetailView.moveProgressBar()
                }

                override fun onResponse(call: Call<FlowerDetail>, response: Response<FlowerDetail>) {
                    flowerDetailView.getFlowerDetails(response.body()?.flower as FlowerX)
                    flowerDetailView.moveProgressBar()
                }

            })
    }
    fun setFlowerFavorite(flower_id:Int,auth_key:String?){
        RetrofitServices.create()
            .postLike(flower_id,auth_key)
            .enqueue(object:Callback<DeleteFavorite>{

                override fun onResponse(call: Call<DeleteFavorite>,response: Response<DeleteFavorite>) {
                    flowerDetailView.getflowerfavorite(response.body()!!.user_id)
                }

                override fun onFailure(call: Call<DeleteFavorite>, t: Throwable) {

                }
            })
    }
}