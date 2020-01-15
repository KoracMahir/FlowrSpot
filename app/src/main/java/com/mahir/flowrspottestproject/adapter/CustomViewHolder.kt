package com.mahir.flowrspottestproject.adapter

import android.content.Context
import android.preference.PreferenceManager
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.Flower
import kotlinx.android.synthetic.main.fragment_flower_detail.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.fav_btn
import kotlinx.android.synthetic.main.recycler_view_item.view.latin_name
import kotlinx.android.synthetic.main.recycler_view_item.view.name
import kotlinx.android.synthetic.main.recycler_view_item.view.sightings

class CustomViewHolder(itemView: View,customAdapterView:CustomAdapterView) : RecyclerView.ViewHolder(itemView){

    val customAdapterView =customAdapterView
    fun bindItems(flower: Flower,list: List<Int>) {
        val profile_pictureURL: String
        if(list.contains(flower.id.toInt())){
            itemView.fav_btn.setBackgroundResource(R.drawable.ic_icon)
        }
        profile_pictureURL = flower.profile_picture
        itemView.latin_name.text = flower.latin_name
        itemView.name.text = flower.name
        itemView.sightings.text = "sightings"+flower.sightings
        Glide.with(itemView)
            .load("https:"+profile_pictureURL)
            .into(itemView.profile_picture1)
        this.itemView.setOnClickListener {
            customAdapterView.sendItemId(flower.id.toInt())
        }
    }
}