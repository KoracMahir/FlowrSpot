package com.mahir.flowrspottestproject.model

data class RegisterPayload(
    val date_of_birth: String,
    val email: String,
    val first_name: String,
    val last_name: String,
    val password: String
)