package com.mahir.flowrspottestproject.views

import android.os.Bundle
import android.preference.PreferenceManager
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
import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.home_adapter.CustomAdapter
import com.mahir.flowrspottestproject.adapter.home_adapter.CustomAdapterView
import com.mahir.flowrspottestproject.interfacex.IFlowerView
import com.mahir.flowrspottestproject.model.FavoriteFlower.FavoriteFlowersResponese
import com.mahir.flowrspottestproject.model.Flower
import com.mahir.flowrspottestproject.presenter.FlowerPresenter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), IFlowerView,
    CustomAdapterView {

    var adapter = CustomAdapter(this)
    var flowerPresenter = FlowerPresenter(this)
    var auth_key : String = "prazno"
    lateinit var list : IntArray
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View= inflater.inflate(R.layout.fragment_home, container, false)



        return view
    }


    override fun onStart() {
        super.onStart()
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            auth_key = getString("auth_token","")
        }
        getSeachableText(requireView())
        flowerPresenter.getFavorite(1,auth_key)
        flowerPresenter.getDataFromApi(1)

        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.favorites -> {
                    findNavController().navigate(R.id.action_homeFragment_to_favoriteFlowersFragment)
                }
                R.id.profile -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                }
            }
            true
        }
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
        adapter.addItems(flower)
        recyclerView.adapter = adapter
    }

    override fun onDataFailiure(throwable: Throwable) {
        Toast.makeText(context, throwable.toString(),Toast.LENGTH_LONG).show()
    }

    override fun sendItemId(id: Int){
        var findNavController : NavController = navController(requireView())
        val action : HomeFragmentDirections.ActionHomeFragmentToFlowerDetailFragment
        action = HomeFragmentDirections.actionHomeFragmentToFlowerDetailFragment(list,auth_key).setFlowerid(id)
        findNavController.navigate(action)
    }

    override fun getFavorites(flowers: List<FavoriteFlowersResponese>){
        list= flowers.map { favFlower -> favFlower.flower.id.toInt() }.toIntArray()
        adapter.addFavorites(list.toList())
    }

    override fun setFavorite(id:Int) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.apply {
            val auth_key = getString("auth_token","")
            flowerPresenter.setFlowerFavorite(id,auth_key)
        }

    }
    override fun onTokenFailiure() {
        findNavController().navigate(R.id.action_homeFragment_to_splashFragment)
    }

    override fun onFavoriteMenu() {
        findNavController().navigate(R.id.action_homeFragment_to_favoriteFlowersFragment)
    }

    override fun onProfileMenu() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
