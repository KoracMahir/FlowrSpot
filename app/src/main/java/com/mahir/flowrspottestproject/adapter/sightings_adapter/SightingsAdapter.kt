package com.mahir.flowrspottestproject.adapter.sightings_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.sightingmodels.FlowerSightingsModel
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting

class SightingsAdapter(sightingsAdapterView: SightingsAdapterView) : RecyclerView.Adapter<SightingsViewHolder>() {

    val sightingsAdapterView = sightingsAdapterView
    var sightingList: List<Sighting> = emptyList()

    fun addItems(flist:List<Sighting>){
        this.sightingList = flist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SightingsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_sighting, parent, false)
        return SightingsViewHolder(v,sightingsAdapterView)
    }

    override fun getItemCount(): Int {
        return sightingList.size
    }

    override fun onBindViewHolder(holder: SightingsViewHolder, position: Int) {
        holder.bindItems(sightingList[position])
    }

}