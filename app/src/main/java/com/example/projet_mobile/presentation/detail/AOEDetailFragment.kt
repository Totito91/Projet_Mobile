package com.example.projet_mobile.presentation.detail

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.projet_mobile.R
import com.example.projet_mobile.presentation.Singletons
import com.example.projet_mobile.presentation.api.AOEDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AOEDetailFragment : Fragment() {
    private lateinit var textViewName: TextView
    private lateinit var textViewArmytype: TextView
    private lateinit var textViewExpansion: TextView
    private lateinit var textViewTeambonus: TextView
    private lateinit var imageViewCiv: ImageView
    val imgArray = arrayOf(R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,
        R.drawable.image13,
        R.drawable.image14,
        R.drawable.image15,
        R.drawable.image16,
        R.drawable.image17,
        R.drawable.image18,
        R.drawable.image19,
        R.drawable.image20,
        R.drawable.image21,
        R.drawable.image22,
        R.drawable.image23,
        R.drawable.image24,
        R.drawable.image25,
        R.drawable.image26,
        R.drawable.image27,
        R.drawable.image28,
        R.drawable.image29,
        R.drawable.image30,
        R.drawable.image31,
        R.drawable.image32
            )
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_aoe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        System.out.println(imgArray)
        imageViewCiv = view.findViewById(R.id.image_detail_civ)
        textViewName = view.findViewById(R.id.civ_detail_name)
        textViewArmytype = view.findViewById(R.id.civ_detail_armytype)
        textViewExpansion = view.findViewById(R.id.civ_detail_expansion)
        textViewTeambonus = view.findViewById(R.id.civ_detail_teambonus)
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
                        textViewName.text = response.body()!!.name
                        textViewArmytype.text = response.body()!!.army_type
                        textViewExpansion.text = response.body()!!.expansion
                        textViewTeambonus.text = response.body()!!.team_bonus
                       imageViewCiv.setImageResource(imgArray[id])
                    }
                }

                override fun onFailure(call: Call<AOEDetailResponse>, t: Throwable) {

                }

            })
        }
    }
}