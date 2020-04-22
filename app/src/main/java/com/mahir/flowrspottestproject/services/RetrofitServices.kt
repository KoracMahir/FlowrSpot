package com.mahir.flowrspottestproject.services

import com.mahir.flowrspottestproject.model.*
import com.mahir.flowrspottestproject.model.sightingmodels.FlowerSightingsModel
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import com.mahir.flowrspottestproject.model.sightingmodels.SightingModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface RetrofitServices{
    @GET("api/v1/flowers?")
    fun getApi(@Query("page") page:Int) : Call<FlowersResponese>

    @GET("api/v1/flowers/search?")
    fun getSearchApi(@Query("query") searchtextingghit:String) : Call<FlowersResponese>

    @GET("/api/v1/flowers/{id}")
    fun getFlowerDetailApi(@Path("id") id:Int) : Call<FlowerDetail>

    @POST("/api/v1/users/login")
    fun postLoginInformation(@Body request: LoginPayload) : Call<LoginResponse>

    @POST("/api/v1/flowers/{flower_id}/favorites")
    fun postLike(@Path("flower_id") flower_id:Int
                ,@Header("Authorization") auth_key:String?) : Call<Flower>

    @GET("/api/v1/flowers/favorites?")
    fun getFavorite(@Query("page") page:Int
                    ,@Header("Authorization") auth_key:String?) : Call<FlowersResponese>

    @GET("/api/v1/users/me/refresh")
    fun refreshToken(@Header("Authorization") auth_key:String?):Call<LoginResponse>

    @POST("/api/v1/users/register")
    fun postRegisterInformation(@Body request: RegisterPayload):Call<LoginResponse>

    @GET("/api/v1/flowers/{id}/sightings")
    fun getFlowerSightings(@Path("id")id:Int):Call<FlowerSightingsModel>

    @GET("/api/v1/sightings/{id}")
    fun getSightingDetails(@Path("id")id:Int):Call<SightingModel>

    //POST SIGHING
    //@POST("/api/v1/sightings")
    //FormData parameters

    @GET("/api/v1/sightings/{sighting_id}/comments")
    fun getComments(@Path("sighting_id")sighting_id:Int): Call<CommentsResponse>

    @POST("/api/v1/sightings/{sighting_id}/comments")
    fun postComment(@Path("sighting_id")sighting_id: Int
                    ,@Body request:CommentPayload
                    ,@Header("Authorization") auth_key:String?):Call<Comment>

    @GET("/api/v1/users/me")
    fun getMyProfileInfo(@Header("Authorization") auth_key: String?) : Call<Profile>

    @GET("/api/v1/sightings")
    fun getSightingList():Call<FlowerSightingsModel>

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