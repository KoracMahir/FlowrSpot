package com.mahir.flowrspottestproject

import android.annotation.SuppressLint
import android.app.ActionBar
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.mahir.flowrspottestproject.adapter.CustomAdapter
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import android.text.TextWatcher;
import android.view.View
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.mahir.flowrspottestproject.views.FlowerDetailFragment
import com.mahir.flowrspottestproject.views.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        if (savedInstanceState == null) {
//            supportFragmentManager
//                .beginTransaction()
//                .add(R.id.homefragment, HomeFragment(), "itemlist")
//                .commit()
//        }
//        onItemClicked()
    }
//    fun onItemClicked() {
//        val detailsFragment =
//            FlowerDetailFragment()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.homefragment, detailsFragment, "itemdetails")
//            .addToBackStack(null)
//            .commit()
//    }
}
