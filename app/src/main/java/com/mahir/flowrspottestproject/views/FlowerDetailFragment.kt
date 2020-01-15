package com.mahir.flowrspottestproject.views

import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

    lateinit var list : List<Int>
    var auth_key : String = "nista"
    var id1 : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flower_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        getArgument()
        flowerPresenter.getFlowerDetail(id1)


        fav_btn.setOnClickListener(View.OnClickListener {
            flowerPresenter.setFlowerFavorite(id1,auth_key)
            changeFavBackground()
        })
    }
    fun getArgument(){
        arguments?.let {
            val safeArgs = FlowerDetailFragmentArgs.fromBundle(it)
            id1 = safeArgs.flowerid
            list = safeArgs.favList.toList()
        }
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            auth_key = getString("auth_token","")
        }
    }
    fun changeFavBackground(){
        fav_btn.setBackgroundResource(R.drawable.ic_icon)
    }
    override fun getFlowerDetails(flowerdetail: Flower) {
        if(list.contains(id1)){
            changeFavBackground()
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

    override fun refreshToken(succerror: Any) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        editor
            .putString("auth_token",succerror.toString())
            .apply()
        getArgument()
    }

    override fun refreshTokenFailed() {
        Toast.makeText(context,"Setting flower favorite failed",Toast.LENGTH_LONG).show()
    }
}
