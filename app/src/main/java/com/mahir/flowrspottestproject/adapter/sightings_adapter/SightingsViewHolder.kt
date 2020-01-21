package com.mahir.flowrspottestproject.adapter.sightings_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.model.sightingmodels.FlowerSightingsModel
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import kotlinx.android.synthetic.main.recycler_view_sighting.view.*

class SightingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bindItems(sightingList: Sighting){
        itemView.name.text = sightingList.name
        itemView.ownername.text = sightingList.user.full_name
    }
}