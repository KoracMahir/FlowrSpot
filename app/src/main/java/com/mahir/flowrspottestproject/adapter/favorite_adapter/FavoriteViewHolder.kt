package com.mahir.flowrspottestproject.adapter.favorite_adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.model.Flower
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bindItems(flower: FavoriteFlowersResponese){
        val profile_pictureURL: String
        itemView.fav_btn.setBackgroundResource(R.drawable.ic_icon)
        profile_pictureURL = flower.flower.profile_picture
        itemView.latin_name.text = flower.flower.latin_name
        itemView.name.text = flower.flower.name
        itemView.sightings.text = "sightings"+flower.flower.sightings
        Glide.with(itemView)
            .load("https:"+profile_pictureURL)
            .into(itemView.profile_picture1)
//        this.itemView.setOnClickListener {
//            customAdapterView.sendItemId(flower.id.toInt())
//        }

    }
}