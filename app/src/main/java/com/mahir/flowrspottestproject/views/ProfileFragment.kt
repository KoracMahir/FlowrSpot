package com.mahir.flowrspottestproject.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.interfacex.ProfileView
import com.mahir.flowrspottestproject.model.User
import com.mahir.flowrspottestproject.presenter.ProfilePresenter
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment(),ProfileView {

    var profilePresenter = ProfilePresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        profilePresenter.getProfileInfo("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyMTgzLCJleHAiOjE1ODc2NDg1Mzd9.lT-yV6uKE4nIfVUYKi1TE0R2s5lnyrXGb_Mt1ekzXMg")
    }

    override fun getMyProfileInformation(user: User) {
        firstname.text = user.first_name
        lastname.text = user.last_name
        name.text = user.first_name + " "+user.last_name
        iduser.text = "id: "+user.id.toString()
        email.text = user.first_name+""+user.last_name+"@gmail.com"
    }

}
