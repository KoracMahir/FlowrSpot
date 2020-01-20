package com.mahir.flowrspottestproject.presenter

import com.mahir.flowrspottestproject.interfacex.RegisterView
import com.mahir.flowrspottestproject.model.LoginResponse
import com.mahir.flowrspottestproject.model.RegisterPayload
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Response

class RegisterPresenter(registerView: RegisterView) {
    val registerview = registerView

    fun postLogin(register: RegisterPayload){
        RetrofitServices.create()
            .postRegisterInformation(register)
            .enqueue(object : retrofit2.Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.code()==400){
                        registerview.registerFailiure(response.body()?.error.toString())
                    }else if(response.code()==200){
                        registerview.registerSuccess(response.body()?.auth_token.toString())
                    }

                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }
            })
    }
}