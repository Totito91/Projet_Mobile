package com.example.projet_mobile.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_mobile.R
import com.example.projet_mobile.presentation.Singletons
import com.example.projet_mobile.presentation.api.AOEListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AOEListFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private val adapter = AOE_Adapter(listOf(), ::onClickedCivilization)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aoe_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.aoe_recyclerview)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@AOEListFragment.adapter
        }


        Singletons.aoeApi.getAOElist().enqueue(object : Callback<AOEListResponse> {
            override fun onFailure(call: Call<AOEListResponse>, t: Throwable) {
               // TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<AOEListResponse>, response: Response<AOEListResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val aoeResponse = response.body()!!
                    adapter.updateList(aoeResponse.civilizations)
                }
            }

        })
    }
    private fun onClickedCivilization(id : Int) {
        findNavController().navigate(R.id.Navigate_To_AOE_Civ_Detail, bundleOf(
                "AOE_Id" to id
        ))
    }
}