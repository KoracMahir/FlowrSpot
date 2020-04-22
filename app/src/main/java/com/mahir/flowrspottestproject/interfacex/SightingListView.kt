package com.mahir.flowrspottestproject.interfacex

import com.mahir.flowrspottestproject.model.sightingmodels.Sighting

interface SightingListView {
    fun getSightingList(sightingsList: List<Sighting>)
}