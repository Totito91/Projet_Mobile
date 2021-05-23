package com.example.projet_mobile.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.projet_mobile.R
import com.example.projet_mobile.presentation.Singletons
import com.example.projet_mobile.presentation.api.AOEDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AOEDetailFragment : Fragment() {
    private lateinit var textViewName: TextView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aoe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName = view.findViewById(R.id.aoe_detail_id)
        callApi()

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.Navigate_To_AOEListFirstFragment)
        }
    }

    private fun callApi() {
        val id: Int? = arguments?.getInt("AOE_Id")?: -1
        if (id != null) {
            Singletons.aoeApi.getAOEdetail(id+1).enqueue(object :Callback<AOEDetailResponse>{
                override fun onResponse(call: Call<AOEDetailResponse>, response: Response<AOEDetailResponse>) {
                    if(response.isSuccessful && response.body() != null){
                        textViewName.text = response.body()!!.id.toString()
                    }
                }

                override fun onFailure(call: Call<AOEDetailResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }
    }
}