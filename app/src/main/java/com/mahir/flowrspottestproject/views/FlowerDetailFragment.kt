package com.mahir.flowrspottestproject.views

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.interfacex.FlowerDetailView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerDetailPresenter
import kotlinx.android.synthetic.main.fragment_flower_detail.*
import kotlinx.android.synthetic.main.fragment_flower_detail.pBar
import java.lang.Exception

class FlowerDetailFragment : Fragment(),FlowerDetailView {

    var flowerPresenter = FlowerDetailPresenter(this)
    var favidlist = listOf<String>()
    var i=true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flower_detail, container, false)
    }

    override fun onStart() {
        super.onStart()

        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            val favlist = getString("favlist","")
            favidlist = favlist.split(",")
            Log.d("list",favlist)
        }

        arguments?.let {
            val safeArgs = FlowerDetailFragmentArgs.fromBundle(it)
            val id1 = safeArgs.flowerid
            flowerPresenter.getFlowerDetail(id1)
            if(favidlist.contains(id1.toString())){ i=false
                fav_btn.setBackgroundResource(R.drawable.ic_icon)
            }else{ i=true
                fav_btn.setBackgroundResource(R.drawable.ic_group)
            }
            fav_btn.setOnClickListener(View.OnClickListener {
                if(i==true){ i=false
                    clickFavBtn(id1)
                    fav_btn.setBackgroundResource(R.drawable.ic_icon)
                }else{ i=true
                    fav_btn.setBackgroundResource(R.drawable.ic_group)
                }
            })
        }
    }
    fun clickFavBtn(id1:Int){
        try{
            val prefs = PreferenceManager.getDefaultSharedPreferences(context)
            prefs.apply {
                val auth_key = getString("auth_token","")
                flowerPresenter.setFlowerFavorite(id1,auth_key)
            }
        }catch (e:Exception){
            Log.d("refresh","go to login")
        }
    }
    override fun getFlowerDetails(flowerdetail: Flower) {
        @NonNull
        if(favidlist.contains(flowerdetail.id.toString())){
            fav_btn.setBackgroundResource(R.drawable.ic_icon)
        }
        name.text = flowerdetail.name
        latin_name.text = flowerdetail.latin_name
        description.text = flowerdetail.description
        sightings.text = flowerdetail.sightings.toString()+" sightings"
        val profile_pictureURL: String
        profile_pictureURL = flowerdetail.profile_picture
        Glide.with(this)
            .load("https:"+profile_pictureURL)
            .into(profile_picture)
    }

    override fun showProgressBar() {
        pBar.visibility = View.VISIBLE
    }

    override fun moveProgressBar() {
        pBar.visibility = View.GONE
    }

    override fun getflowerfavorite(flowerFavorite: Int) {

    }
}
