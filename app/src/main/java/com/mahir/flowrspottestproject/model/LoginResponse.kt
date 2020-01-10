package com.mahir.flowrspottestproject.model

import androidx.annotation.Nullable

data class LoginResponse(
    @Nullable val auth_token: Any?,
    @Nullable val error : Any?
)