package com.mahir.flowrspottestproject.presenter

import android.widget.Toast
import com.mahir.flowrspottestproject.interfacex.FlowerDetailView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.model.FlowerDetail
import com.mahir.flowrspottestproject.model.FlowerX
import com.mahir.flowrspottestproject.model.Flowers
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

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
}