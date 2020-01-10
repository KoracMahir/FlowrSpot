package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.LoginResponse

interface LoginView {
    fun loginSuccess(succerror:Any)
    fun loginFailiure(throwable: Throwable)
}