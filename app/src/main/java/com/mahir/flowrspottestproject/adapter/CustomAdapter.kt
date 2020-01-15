package com.mahir.flowrspottestproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.Flower


class CustomAdapter(customAdapterView : CustomAdapterView) : RecyclerView.Adapter<CustomViewHolder>(){

    val customAdapterView = customAdapterView
    var flowerList: List<Flower> = emptyList()
    var favoriteflower: List<Int> = emptyList()

    fun addItems(flist:List<Flower>){
        this.flowerList = flist
    }
    fun addFavorites(favlist:List<Int>){
        this.favoriteflower = favlist
    }
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CustomViewHolder(v,customAdapterView)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindItems(flowerList[position],favoriteflower)
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return flowerList.size
    }


}