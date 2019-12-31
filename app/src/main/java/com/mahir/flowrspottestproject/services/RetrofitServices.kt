package com.mahir.flowrspottestproject.services

import com.mahir.flowrspottestproject.model.Flowers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServices{
    @GET("api/v1/flowers?")
    fun getApi(@Query("page") page:Int) : Call<Flowers>

    @GET("api/v1/flowers/search?")
    fun getSearchApi(@Query("query") searchtext:String) : Call<Flowers>

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