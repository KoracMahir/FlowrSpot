package com.mahir.flowrspottestproject.views


import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.favorite_adapter.FavoriteAdapter
import com.mahir.flowrspottestproject.interfacex.FavFlowersView
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.presenter.FavFlowerPresenter
import kotlinx.android.synthetic.main.fragment_favorite_flowers.*

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFlowersFragment : Fragment(),FavFlowersView {


    var adapter = FavoriteAdapter()
    var auth_key : String = "nista"
    val favFlowerPresenter = FavFlowerPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorite_flowers, container, false)
    }

    override fun onStart() {
        super.onStart()
        bottom_navigation.selectedItemId = R.id.favorites
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            auth_key = getString("auth_token","")
        }
        favFlowerPresenter.getFavorite(1,auth_key)
    }
    override fun getFavorites(flowers: List<FavoriteFlowersResponese>) {
        adapter.addItems(flowers)
        recyclerView.adapter = adapter
    }
    override fun onTokenFailiure() {
        findNavController().navigate(R.id.action_favoriteFlowersFragment_to_homeFragment)
    }

    override fun pBarShow() {
        pBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun pBarHide() {
        pBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }
}
