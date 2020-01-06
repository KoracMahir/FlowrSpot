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








class CustomAdapter : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var flowerList: List<Flower> = emptyList()
    var findNavController: NavController? = null

    fun CustomAdapter(flist:List<Flower>,navcon:NavController){
        this.flowerList = flist
        this.findNavController = navcon
    }

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        val vHolder : ViewHolder = ViewHolder(v)
        return vHolder
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(flowerList[position])


        try {
            holder.itemView.setOnClickListener {

                val action : HomeFragmentDirections.ActionHomeFragmentToFlowerDetailFragment
                action = HomeFragmentDirections.actionHomeFragmentToFlowerDetailFragment().setFlowerid(holder.getItemId(flowerList[position]))
                findNavController?.navigate(action)
                Log.d("massage","id: "+holder.getItemId(flowerList[position]))
            }
        }catch (e:Exception){
            Log.d("massage","error: "+e.toString())
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return flowerList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

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
        fun getItemId(flower: Flower):Int{
            return flower.id.toInt()
        }

    }
}