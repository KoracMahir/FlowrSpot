package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.*
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FlowerPresenter(flowerView: IFlowerView){
    val flowerView = flowerView

    fun getDataFromApi(page:Int){
        flowerView.showProgressBar()
        RetrofitServices.create()
            .getApi(page)
            .enqueue(object : Callback<FlowersResponese>{
                override fun onResponse(call: Call<FlowersResponese>, response: Response<FlowersResponese>) {
                    flowerView.getFlowers(response.body()?.flowers as List<Flower>)
                    flowerView.moveProgressBar()
                }
                override fun onFailure(call: Call<FlowersResponese>, t: Throwable) {
                    flowerView.onDataFailiure(t)
                    flowerView.moveProgressBar()
                }
            })
    }
    fun getSeachDataFromApi(flowername:String){
        flowerView.showProgressBar()
        RetrofitServices.create()
            .getSearchApi(flowername)
            .enqueue(object : Callback<FlowersResponese>{
                override fun onResponse(call: Call<FlowersResponese>, response: Response<FlowersResponese>) {
                    flowerView.getFlowers(response.body()?.flowers as List<Flower>)
                    flowerView.moveProgressBar()
                }
                override fun onFailure(call: Call<FlowersResponese>, t: Throwable) {
                    flowerView.onDataFailiure(t)
                    flowerView.moveProgressBar()
                }
            })
    }

    fun getFavorite(page:Int,auth_key:String?){
        RetrofitServices.create()
            .getFavorite(page,auth_key)
            .enqueue(object : Callback<FlowersResponese>{
                override fun onResponse(call: Call<FlowersResponese>, response: Response<FlowersResponese>) {
                    if (response.code()==401)
                        flowerView.refreshTokenFailed()
                    else
                        flowerView.getFavorites(response.body()?.fav_flowers as List<FavoriteFlowersResponese>)
                }

                override fun onFailure(call: Call<FlowersResponese>, t: Throwable) {
                    flowerView.onDataFailiure(t)
                }
            })
    }
    fun setFlowerFavorite(flower_id:Int,auth_key:String?){
        RetrofitServices.create()
            .postLike(flower_id,auth_key)
            .enqueue(object: Callback<Flower> {
                override fun onResponse(call: Call<Flower>, response: Response<Flower>) {}
                override fun onFailure(call: Call<Flower>, t: Throwable) {}
            })
    }

    fun refreshToken(auth_key:String){
        RetrofitServices.create()
            .refreshToken(auth_key)
            .enqueue(object : Callback<LoginResponse> {

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    flowerView.refreshToken(response.body()?.auth_token.toString())
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    flowerView.refreshTokenFailed()
                }

            })
    }
}