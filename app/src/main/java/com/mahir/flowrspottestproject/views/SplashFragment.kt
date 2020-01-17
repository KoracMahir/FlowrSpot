package com.mahir.flowrspottestproject.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.interfacex.SplashScreenView
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import com.mahir.flowrspottestproject.presenter.SplashScreenPresenter

class SplashFragment : Fragment(),SplashScreenView {
    var splashScreenPresenter = SplashScreenPresenter(this)
    var auth_key : String = "prazno"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onStart() {
        super.onStart()
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            auth_key = getString("auth_token","")
        }
        splashScreenPresenter.refreshToken(auth_key)
    }
    override fun refreshTokenFailed() {
        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
    }

    override fun refreshToken(succerror: Any) {
        var auth_token ="prazantoken"
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        auth_token=succerror.toString()
        val editor = prefs.edit()
        editor
            .putString("auth_token",auth_token)
            .apply()
        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
    }
}
