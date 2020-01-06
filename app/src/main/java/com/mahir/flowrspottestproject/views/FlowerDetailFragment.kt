package com.mahir.flowrspottestproject.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.interfacex.FlowerDetailView
import com.mahir.flowrspottestproject.model.FlowerX
import com.mahir.flowrspottestproject.presenter.FlowerDetailPresenter
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import kotlinx.android.synthetic.main.fragment_flower_detail.*
import kotlinx.android.synthetic.main.fragment_flower_detail.pBar

class FlowerDetailFragment : Fragment(),FlowerDetailView {

    var flowerPresenter = FlowerDetailPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flower_detail, container, false)
    }

    override fun onViewCreated(view: View,  savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = FlowerDetailFragmentArgs.fromBundle(it)
            val id1 = safeArgs.flowerid
            flowerPresenter.getFlowerDetail(id1)
        }
    }
    override fun getFlowerDetails(flowerdetail: FlowerX) {
        @NonNull
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

}
