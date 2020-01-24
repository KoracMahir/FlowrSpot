package com.mahir.flowrspottestproject.model

data class Comment(
    val id:Int,
    val user_id:Int,
    val user_full_name:String,
    val sighting_id:Int,
    val content:String
)