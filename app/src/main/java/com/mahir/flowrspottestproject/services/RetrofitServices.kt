package com.mahir.flowrspottestproject.services

import com.mahir.flowrspottestproject.model.*
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowers
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitServices{
    @GET("api/v1/flowers?")
    fun getApi(@Query("page") page:Int) : Call<Flowers>

    @GET("api/v1/flowers/search?")
    fun getSearchApi(@Query("query") searchtext:String) : Call<Flowers>

    @GET("/api/v1/flowers/{id}")
    fun getFlowerDetailApi(@Path("id") id:Int) : Call<FlowerDetail>

    @POST("/api/v1/users/login")
    fun postLoginInformation(@Body request: Login) : Call<LoginResponse>

    @POST("/api/v1/flowers/{flower_id}/favorites")
    fun postLike(@Path("flower_id") flower_id:Int
                ,@Header("Authorization") auth_key:String?) : Call<DeleteFavorite>

    @DELETE("/api/v1/flowers/{flower_id}/favorites/{id}")
    fun deleteLike(@Path("flower_id")flower_id: Int
                ,@Path("id")id: Int
                ,@Header("Authorization") auth_key:String?) : Call<DeleteFavorite>

    @GET("/api/v1/flowers/favorites?")
    fun getFavorite(@Query("page") page:Int
                    ,@Header("Authorization") auth_key:String?) : Call<FavoriteFlowers>

    @GET("/api/v1/users/me/refresh")
    fun refreshToken(@Header("Authorization") auth_key:String?):Call<LoginResponse>


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