package com.mahir.flowrspottestproject.adapter

import android.app.PendingIntent.getActivity
import android.net.NetworkInfo
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahir.flowrspottestproject.MainActivity
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.Flower
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import androidx.appcompat.app.AppCompatActivity
import com.mahir.flowrspottestproject.views.FlowerDetailFragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import com.mahir.flowrspottestproject.views.HomeFragment
import com.mahir.flowrspottestproject.views.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_flower_detail.view.*
import kotlinx.android.synthetic.main.recycler_view_item.view.latin_name
import kotlinx.android.synthetic.main.recycler_view_item.view.name
import kotlinx.android.synthetic.main.recycler_view_item.view.profile_picture
import kotlinx.android.synthetic.main.recycler_view_item.view.sightings
import java.lang.Exception








class CustomAdapter : RecyclerView.Adapter<CustomViewHolder>(){

    var flowerList: List<Flower> = emptyList()


    fun customAdapter(flist:List<Flower>){
        this.flowerList = flist
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val vHolder : CustomViewHolder = CustomViewHolder(v)



        return vHolder
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindItems(flowerList[position])
        holder.sendItemId(flowerList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return flowerList.size
    }


}