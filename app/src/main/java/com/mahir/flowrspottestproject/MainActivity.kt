package com.mahir.flowrspottestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.adapter.CustomAdapter
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),IFlowerView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FlowerPresenter(this).getDataFromApi()
    }
    override fun getFlowers(flower: List<Flower>) {
        recyclerView.layoutManager = GridLayoutManager(this,2)
        val adapter = CustomAdapter(flower)
        recyclerView.adapter = adapter
    }

    override fun onDataFailiure(throwable: Throwable) {
        Toast.makeText(this, throwable.toString(),Toast.LENGTH_LONG).show()
    }
}
