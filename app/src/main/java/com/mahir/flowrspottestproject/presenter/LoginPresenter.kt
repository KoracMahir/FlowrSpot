package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.LoginView
import com.mahir.flowrspottestproject.model.LoginPayload
import com.mahir.flowrspottestproject.model.LoginResponse
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Response

class LoginPresenter(loginview: LoginView){
    val loginView = loginview

    fun postLogin(login: LoginPayload){
        RetrofitServices.create()
            .postLoginInformation(login)
            .enqueue(object : retrofit2.Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.code()==400){
                        loginView.loginFailiure(response.body()?.error.toString())
                    }else if(response.code()==200){
                        loginView.loginSuccess(response.body()?.auth_token.toString())
                    }

                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }
            })
    }

}