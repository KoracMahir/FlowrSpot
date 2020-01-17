package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.SplashScreenView
import com.mahir.flowrspottestproject.model.LoginResponse
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashScreenPresenter (splashscreenview:SplashScreenView){
    val splashscreenview = splashscreenview

    fun refreshToken(auth_key:String){
        RetrofitServices.create()
            .refreshToken(auth_key)
            .enqueue(object : Callback<LoginResponse> {

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(response.code()==200)
                        splashscreenview.refreshToken(response.body()?.auth_token.toString())
                    else
                        splashscreenview.refreshTokenFailed()
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    splashscreenview.refreshTokenFailed()
                }

            })
    }
}