package com.mahir.flowrspottestproject.presenter

import android.content.Context
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.model.Flowers
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerPresenter(flowerView: IFlowerView){
    val flowerView = flowerView

    fun getDataFromApi(page:Int){
//        flowerView.showProgressBar()
        RetrofitServices.create()
            .getApi(page)
            .enqueue(object : Callback<Flowers>{
                override fun onResponse(call: Call<Flowers>, response: Response<Flowers>) {
                    flowerView.getFlowers(response.body()?.flowers as List<Flower>)
                    flowerView.moveProgressBar()
                }
                override fun onFailure(call: Call<Flowers>, t: Throwable) {
                    flowerView.onDataFailiure(t)
                    flowerView.moveProgressBar()
                }
            })
    }
    fun getSeachDataFromApi(flowername:String){
//        flowerView.showProgressBar()
        RetrofitServices.create()
            .getSearchApi(flowername)
            .enqueue(object : Callback<Flowers>{
                override fun onResponse(call: Call<Flowers>, response: Response<Flowers>) {
                    flowerView.getFlowers(response.body()?.flowers as List<Flower>)
                    flowerView.moveProgressBar()
                }
                override fun onFailure(call: Call<Flowers>, t: Throwable) {
                    flowerView.onDataFailiure(t)
                    flowerView.moveProgressBar()
                }
            })
    }

}