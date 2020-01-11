package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.LoginResponse

interface LoginView {
    fun loginSuccess(succerror:String?)
    fun loginFailiure(throwable: String?)
}