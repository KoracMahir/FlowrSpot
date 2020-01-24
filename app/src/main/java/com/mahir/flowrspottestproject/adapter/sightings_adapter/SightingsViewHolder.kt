package com.mahir.flowrspottestproject.adapter.sightings_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahir.flowrspottestproject.model.sightingmodels.FlowerSightingsModel
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import kotlinx.android.synthetic.main.recycler_view_sighting.view.*
import kotlinx.android.synthetic.main.recycler_view_sighting.view.name
import kotlinx.android.synthetic.main.recycler_view_sighting.view.profile_picture

class SightingsViewHolder(itemView: View,sightingsAdapterView: SightingsAdapterView) : RecyclerView.ViewHolder(itemView){

    val sightingsAdapterView = sightingsAdapterView
    fun bindItems(sightingList: Sighting){
        val flowerimageURL : String
        itemView.name.text = sightingList.name
        itemView.ownername.text = "by "+sightingList.user.full_name
        itemView.description.text = sightingList.description
        itemView.commentnum.text = sightingList.comments_count.toString()+" Comments"
        itemView.fav_num.text = sightingList.likes_count.toString()+" Favorites"
        flowerimageURL = sightingList.picture
        Glide.with(itemView)
            .load("https:"+flowerimageURL)
            .apply(RequestOptions.circleCropTransform())
            .into(itemView.profile_picture)
        this.itemView.setOnClickListener {
            sightingsAdapterView.sendSightingId(sightingList.id)
        }
    }
}