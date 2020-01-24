package com.mahir.flowrspottestproject.model

import com.mahir.flowrspottestproject.model.sightingmodels.Meta_1

data class CommentsResponse(
    val comments:List<Comment>,
    val meta : Meta_1
)