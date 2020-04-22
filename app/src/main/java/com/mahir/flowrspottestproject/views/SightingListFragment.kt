package com.mahir.flowrspottestproject.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.mahir.flowrspottestproject.R
import com.mahir.flowrspottestproject.adapter.sightings_adapter.SightingsAdapter
import com.mahir.flowrspottestproject.adapter.sightings_adapter.SightingsAdapterView
import com.mahir.flowrspottestproject.interfacex.SightingListView
import com.mahir.flowrspottestproject.model.sightingmodels.Sighting
import com.mahir.flowrspottestproject.presenter.SightingListPresenter
import kotlinx.android.synthetic.main.fragment_sighting_list.*

/**
 * A simple [Fragment] subclass.
 */
class SightingListFragment : Fragment(), SightingListView, SightingsAdapterView {

    val sightingListPresenter = SightingListPresenter(this)
    var adapter = SightingsAdapter(this)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sighting_list, container, false)
    }

    override fun onStart() {
        bottom_navigation.selectedItemId = R.id.sightings
        sightingListPresenter.getSightings()
        super.onStart()
    }

    override fun getSightingList(sightingsList: List<Sighting>) {
        adapter.addItems(sightingsList)
        recyclerView.adapter = adapter
    }

    fun navController(view: View): NavController {
        val navController = Navigation.findNavController(view)
        return navController
    }

    override fun sendSightingId(id: Int) {
        var findNavController : NavController = navController(requireView())
        val action : SightingListFragmentDirections.ActionSightingListFragment2ToSightingDetailFragment
        action = SightingListFragmentDirections.actionSightingListFragment2ToSightingDetailFragment().setSightingId(id)
        findNavController.navigate(action)
    }
}
