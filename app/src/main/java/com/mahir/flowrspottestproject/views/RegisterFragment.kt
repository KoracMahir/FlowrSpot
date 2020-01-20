package com.mahir.flowrspottestproject.views


import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.interfacex.RegisterView
import com.mahir.flowrspottestproject.model.RegisterPayload
import com.mahir.flowrspottestproject.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(),RegisterView {

    var registerPresenter = RegisterPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
        registerbtn.setOnClickListener(View.OnClickListener {
            registerPresenter.postLogin(RegisterPayload(firstname.text.toString(),lastname.text.toString(),dateofbirth.text.toString(),email.text.toString(),password.text.toString()))
        })
    }

    fun navController(view: View):NavController{
        val navController = Navigation.findNavController(view)
        return navController
    }

    override fun registerSuccess(situation: String?) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        if (situation!="null"){
            editor
                .putString("auth_token",situation.toString())
                .apply()
            var findNavController : NavController = navController(requireView())
//            findNavController.navigate(R.id.action_loginFragment_to_splashFragment)
        }
    }

    override fun registerFailiure(throwable: String?) {
        if (throwable=="null") {
            Toast.makeText(context, "Wrong email or password", Toast.LENGTH_LONG).show()
        }
    }

}
