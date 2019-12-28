package com.mahir.flowrspottestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity(),IFlowerView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun getFlowers(flower: List<Flower>) {
        text1.text = flower[0].favorite.toString()
        text2.text = flower[0].id.toString()
        text3.text = flower[0].latin_name.toString()
        text4.text = flower[0].name.toString()
        text5.text = flower[0].profile_picture.toString()
        text6.text = flower[0].sightings.toString()
    }

    override fun onDataFailiure(throwable: Throwable) {
        Toast.makeText(this, throwable.toString(),Toast.LENGTH_LONG).show()
    }
}
