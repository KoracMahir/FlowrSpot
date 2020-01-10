package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.DeleteFavorite
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavFlower
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowers
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.model.Flowers
import com.mahir.flowrspottestproject.model.LoginResponse
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
        flowerView.showProgressBar()
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

    fun getFavorite(page:Int,auth_key:String?){
        RetrofitServices.create()
            .getFavorite(page,auth_key)
            .enqueue(object : Callback<FavoriteFlowers>{
                override fun onResponse(call: Call<FavoriteFlowers>, response: Response<FavoriteFlowers>) {
                    if (response.code()==401)
                        flowerView.refreshTokenFailed()
                    else
                        flowerView.getFavorites(response.body()?.fav_flowers as List<FavFlower>)
                }

                override fun onFailure(call: Call<FavoriteFlowers>, t: Throwable) {
                    flowerView.onDataFailiure(t)
                }
            })
    }
    fun setFlowerFavorite(flower_id:Int,auth_key:String?){
        RetrofitServices.create()
            .postLike(flower_id,auth_key)
            .enqueue(object: Callback<DeleteFavorite> {
                override fun onResponse(call: Call<DeleteFavorite>, response: Response<DeleteFavorite>) {

                }

                override fun onFailure(call: Call<DeleteFavorite>, t: Throwable) {

                }
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