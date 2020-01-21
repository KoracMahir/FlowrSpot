package com.mahir.flowrspottestproject.adapter.favorite_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.favorite_adapter.FavoriteViewHolder
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.model.Flower

class FavoriteAdapter : RecyclerView.Adapter<FavoriteViewHolder>(){

    var flowerList: List<FavoriteFlowersResponese> = emptyList()

    fun addItems(flist:List<FavoriteFlowersResponese>){
        this.flowerList = flist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return FavoriteViewHolder(v)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItems(flowerList[position])
    }
}