package com.mahir.flowrspottestproject.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.interfacex.LoginView
import com.mahir.flowrspottestproject.model.Login
import com.mahir.flowrspottestproject.model.LoginResponse
import com.mahir.flowrspottestproject.presenter.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import java.lang.Exception

class LoginFragment : Fragment(),LoginView {

    var loginPresenter = LoginPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
}

    override fun onStart() {
        super.onStart()

        loginbtn.setOnClickListener(View.OnClickListener {
            loginPresenter.postLogin(Login(editemail.text.toString(),editpass.text.toString()))
        })
    }
    fun navController(view: View):NavController{
        val navController = Navigation.findNavController(view)
        return navController
    }
    override fun loginSuccess(situation: Any) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        if (situation!="null"){
            editor
                .putString("auth_token",situation.toString())
                .apply()
            var findNavController : NavController = navController(requireView())
            findNavController.navigate(R.id.action_loginFragment_to_homeFragment)
        }else{
            Toast.makeText(context,"Wrong email/password",Toast.LENGTH_LONG).show()
        }
    }

    override fun loginFailiure(throwable: Throwable) {
    }
}
