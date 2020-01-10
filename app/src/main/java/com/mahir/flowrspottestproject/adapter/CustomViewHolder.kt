package com.mahir.flowrspottestproject.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahir.flowrspottestproject.MainActivity
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.model.DeleteFavorite
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.services.RetrofitServices
import com.mahir.flowrspottestproject.views.HomeFragment
import kotlinx.android.synthetic.main.fragment_flower_detail.*
import kotlinx.android.synthetic.main.recycler_view_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.coroutineContext

class CustomViewHolder(itemView: View,customAdapterView:CustomAdapterView,context: Context) : RecyclerView.ViewHolder(itemView){
    var context : Context = context
    val customAdapterView =customAdapterView
    var favidlist = listOf<String>()
    var i=true
    fun bindItems(flower: Flower) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            val favlist =getString("favlist", "")
            favidlist = favlist.split(",")
        }
        if(favidlist.contains(flower.id)){ i=false
            itemView.fav_btn.setBackgroundResource(R.drawable.ic_icon)
        }else{ i=true
            itemView.fav_btn.setBackgroundResource(R.drawable.ic_group)
        }
        itemView.fav_btn.setOnClickListener(View.OnClickListener {
            prefs.apply {
                val auth_key = getString("auth_token","")
                if(i==true){
                    i=false
                    customAdapterView.setFavorite(flower.id.toInt())
                    itemView.fav_btn.setBackgroundResource(R.drawable.ic_icon)
                }else{
                    i=true
                    itemView.fav_btn.setBackgroundResource(R.drawable.ic_group)
                }
            }

        })
        val profile_pictureURL: String
        profile_pictureURL = flower.profile_picture
        itemView.latin_name.text = flower.latin_name
        itemView.name.text = flower.name
        itemView.sightings.text = "sightings"+flower.sightings
        Glide.with(itemView)
            .load("https:"+profile_pictureURL)
            .into(itemView.profile_picture)

        this.itemView.setOnClickListener {
            customAdapterView.sendItemId(flower.id.toInt())
        }
    }
}