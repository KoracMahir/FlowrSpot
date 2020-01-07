package com.mahir.flowrspottestproject.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.views.HomeFragmentDirections
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import java.lang.Exception

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val customAdapterView : CustomAdapterView? = null

    fun bindItems(flower: Flower) {
        val profile_pictureURL: String
        profile_pictureURL = flower.profile_picture
        itemView.latin_name.text = flower.latin_name
        itemView.name.text = flower.name
        itemView.sightings.text = "sightings"+flower.sightings
        Glide.with(itemView)
            .load("https:"+profile_pictureURL)
            .into(itemView.profile_picture)


    }
    fun sendItemId(flower: Flower){
        val holder = CustomViewHolder(itemView)
        holder.itemView.setOnClickListener {
            if (customAdapterView != null) {
                Log.d("id: ",flower.id)
                customAdapterView.sendItemId(flower.id.toInt())
            }
        }
    }
    fun getItemId(flower: Flower):Int{
        return flower.id.toInt()
    }
    interface sentData{
        fun sendID(id:Int)
    }
}