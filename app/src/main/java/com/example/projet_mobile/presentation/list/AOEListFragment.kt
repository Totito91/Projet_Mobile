package com.example.projet_mobile.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_mobile.R
import com.example.projet_mobile.presentation.api.AOEApi
import com.example.projet_mobile.presentation.api.AOEResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AOEListFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private val adapter = AOE_Adapter(listOf(), ::onClickedCivilization)




    private val layoutManager = LinearLayoutManager(context)
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
            layoutManager = this@AOEListFragment.layoutManager
            adapter = this@AOEListFragment.adapter
        }


        val retrofit = Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val aoeApi: AOEApi = retrofit.create(AOEApi::class.java)

        aoeApi.getAOElist().enqueue(object : Callback<AOEResponse> {
            override fun onFailure(call: Call<AOEResponse>, t: Throwable) {
               // TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<AOEResponse>, response: Response<AOEResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val aoeResponse = response.body()!!
                    adapter.updateList(aoeResponse.civilizations)
                }
            }

        })


      /*  code pour naviguer entre les fragments
      view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }
    private fun onClickedCivilization(civilizations: civilizations) {
        findNavController().navigate(R.id.Navigate_To_AOE_Civ_Detail)
    }
}