package com.mahir.flowrspottestproject.services

import com.mahir.flowrspottestproject.model.Flowers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RetrofitServices{
    @GET("api/v1/flowers?page=0")
    fun getApi() : Call<Flowers>

    companion object {
        fun create(): RetrofitServices{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://flowrspot-api.herokuapp.com")
                .build()
            return retrofit.create(RetrofitServices::class.java)
        }
    }

}