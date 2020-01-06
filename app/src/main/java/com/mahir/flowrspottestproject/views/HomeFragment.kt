package com.mahir.flowrspottestproject.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahir.flowrspottestproject.MainActivity
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.CustomAdapter
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment(), IFlowerView {

    var flowerPresenter = FlowerPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)

        flowerPresenter.getDataFromApi(1)
        getSeachableText(view)
        return view
    }

    override fun onViewCreated(view: View,  savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        navController(view).navigate(R.id.action_homeFragment_to_flowerDetailFragment)
    }
    fun navController(view: View):NavController{
        val navController = Navigation.findNavController(view)
        return navController
    }
    override fun showProgressBar() {
        pBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun moveProgressBar() {
        pBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    fun getSeachableText(view: View){
        val edittext = view.findViewById(R.id.menu_search) as EditText
        try {
            edittext.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    if(p0.toString().isEmpty())
                        flowerPresenter.getDataFromApi(1)
                    else
                        flowerPresenter.getSeachDataFromApi(p0.toString())
                }
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    flowerPresenter.getSeachDataFromApi(p0.toString())
                }
            })
        }catch (e:Exception){
            Toast.makeText(context, e.toString(),Toast.LENGTH_LONG).show()
        }
    }
    override fun getFlowers(flower: List<Flower>) {
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.setHasFixedSize(true)
        val adapter = CustomAdapter(flower,navController(requireView()))
        recyclerView.adapter = adapter
    }

    override fun getFlowerSearch(flowers: List<Flower>) {
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.setHasFixedSize(true)
        val adapter = CustomAdapter(flowers,navController(requireView()))
        recyclerView.adapter = adapter
    }

    override fun onDataFailiure(throwable: Throwable) {
        Toast.makeText(context, throwable.toString(),Toast.LENGTH_LONG).show()
    }
}
