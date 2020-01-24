package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.Comment
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting

interface SightingDetailView {
    fun getComments(comments: List<Comment>)
    fun getDetails(sightingdetail:Sighting)
}