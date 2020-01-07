package com.mahir.flowrspottestproject.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahir.flowrspottestproject.model.Flower
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CustomViewHolder(itemView: View, customAdapterView: CustomAdapterView) : RecyclerView.ViewHolder(itemView){

    val customAdapterView =customAdapterView

    fun bindItems(flower: Flower) {
        val profile_pictureURL: String
        profile_pictureURL = flower.profile_picture
        itemView.latin_name.text = flower.latin_name
        itemView.name.text = flower.name
        itemView.sightings.text = "sightings"+flower.sightings
        Glide.with(itemView)
            .load("https:"+profile_pictureURL)
            .into(itemView.profile_picture)

        val holder = CustomViewHolder(itemView,customAdapterView)
        holder.itemView.setOnClickListener {
            Log.d("id: ",flower.id)
            customAdapterView?.sendItemId(flower.id.toInt())
        }
    }
}