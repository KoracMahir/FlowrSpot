package com.mahir.flowrspottestproject

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.mahir.flowrspottestproject.adapter.CustomAdapter
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextWatcher;
import android.view.View

class MainActivity : AppCompatActivity(),IFlowerView{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FlowerPresenter(this).getDataFromApi(0)
        GetSeachableText(this)

    }
    fun GetSeachableText(context: Context){
        menu_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if(p0.toString()=="")
                    FlowerPresenter(context).getDataFromApi(0)
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                FlowerPresenter(context).getSeachDataFromApi(p0.toString())
            }
        })
    }
    fun ParseSeachableText(seach:String):String{
        return seach
    }
    override fun getFlowers(flower: List<Flower>) {
        recyclerView.layoutManager = GridLayoutManager(this,2)
        val adapter = CustomAdapter(flower)
        recyclerView.adapter = adapter
    }

    override fun getFlowerSearch(flowers: List<Flower>) {
        recyclerView.layoutManager = GridLayoutManager(this,2)
        val adapter = CustomAdapter(flowers)
        recyclerView.adapter = adapter
    }

    override fun onDataFailiure(throwable: Throwable) {
        Toast.makeText(this, throwable.toString(),Toast.LENGTH_LONG).show()
    }
}
