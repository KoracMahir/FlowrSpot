package com.mahir.flowrspottestproject.model

import androidx.annotation.Nullable

data class User (
    @Nullable val id : Int?,
    @Nullable val first_name : String?,
    @Nullable val last_name : String?
)