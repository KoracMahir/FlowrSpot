package com.mahir.flowrspottestproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.Flower

class CustomAdapter(val flowerList: List<Flower>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(flowerList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return flowerList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(flower: Flower) {
            val latin_name = itemView.findViewById(R.id.latin_name) as TextView
            val name = itemView.findViewById(R.id.name) as TextView
            val sightings = itemView.findViewById(R.id.sightings) as TextView
            latin_name.text = flower.latin_name
            name.text = flower.name
            sightings.text = "sightings: "+flower.sightings
        }
    }
}