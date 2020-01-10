package com.mahir.flowrspottestproject.adapter

import androidx.navigation.NavController

interface CustomAdapterView{
    fun sendItemId(id:Int)
    fun setFavorite(id:Int)
    fun delteFavorite(id:Int)
}