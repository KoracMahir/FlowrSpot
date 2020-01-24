package com.mahir.flowrspottestproject.views


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.sighting_comment_adapter.SightingCommentAdapter
import com.mahir.flowrspottestproject.adapter.sightings_adapter.SightingsAdapterView
import com.mahir.flowrspottestproject.interfacex.SightingDetailView
import com.mahir.flowrspottestproject.model.Comment
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import com.mahir.flowrspottestproject.presenter.SightingDetailPresenter
import kotlinx.android.synthetic.main.fragment_sighting_detail.*

class SightingDetailFragment : Fragment(),SightingDetailView {

    var adapter = SightingCommentAdapter()
    val sightingDetailPresenter = SightingDetailPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sighting_detail, container, false)
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            val safeArgs = SightingDetailFragmentArgs.fromBundle(it)
            val id = safeArgs.sightingId
            sightingDetailPresenter.getComments(id)
            sightingDetailPresenter.getDetails(id)
        }
    }

    override fun getComments(comments: List<Comment>) {
        adapter.addItems(comments)
        recyclerView_sighting_detail.adapter = adapter
    }
    override fun getDetails(sightingdetail: Sighting) {
        val profile_pictureURL: String
        profile_pictureURL = sightingdetail.picture
        Glide.with(this)
            .load("https:"+profile_pictureURL)
            .apply(RequestOptions.circleCropTransform())
            .into(profile_picture)
        Glide.with(this)
            .load("https:"+profile_pictureURL)
            .into(imageflower)
        name.text=sightingdetail.name
        ownername.text = "by: "+sightingdetail.user.full_name
        commentnum.text=sightingdetail.comments_count.toString()+" comments"
        commentnumber.text=sightingdetail.comments_count.toString()+" comments"
        fav_num.text=sightingdetail.likes_count.toString()+" favorites"
    }
}
