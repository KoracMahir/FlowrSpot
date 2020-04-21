package com.mahir.flowrspottestproject.presenter


import android.util.Log
import com.mahir.flowrspottestproject.interfacex.ProfileView
import com.mahir.flowrspottestproject.model.Profile
import com.mahir.flowrspottestproject.model.User
import com.mahir.flowrspottestproject.services.RetrofitServices
import retrofit2.Call
import retrofit2.Response


class ProfilePresenter(profileView: ProfileView) {
    val profileview = profileView

    fun getProfileInfo(auth_key:String?){
        RetrofitServices.create()
            .getMyProfileInfo(auth_key)
            .enqueue(object : retrofit2.Callback<Profile>{
                override fun onResponse(call: Call<Profile>, response: Response<Profile>) {
                    profileview.getMyProfileInformation(response.body()?.user as User)
                }
                override fun onFailure(call: Call<Profile>, t: Throwable) {

                }
            })
    }
}