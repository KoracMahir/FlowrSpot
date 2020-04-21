package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.Profile
import com.mahir.flowrspottestproject.model.User

interface ProfileView {
    fun getMyProfileInformation(user:User)
}