package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.FavFlowersView
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.model.FlowersResponese
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavFlowerPresenter(favFlowersView: FavFlowersView) {

    val favFlowersView = favFlowersView

    fun getFavorite(page:Int,auth_key:String?){
        RetrofitServices.create()
            .getFavorite(page,auth_key)
            .enqueue(object : Callback<FlowersResponese> {
                override fun onResponse(call: Call<FlowersResponese>, response: Response<FlowersResponese>) {
                    if (response.code()==401) {
                        favFlowersView.onTokenFailiure()
                        favFlowersView.pBarShow()}
                    else {
                        favFlowersView.getFavorites(response.body()?.fav_flowers as List<FavoriteFlowersResponese>)
                        favFlowersView.pBarHide()}
                }

                override fun onFailure(call: Call<FlowersResponese>, t: Throwable) {

                }
            })
    }
}