package com.example.projet_mobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projet_mobile.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AOEListFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private val adapter = AOE_Adapter(listOf())
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

        val aoeList = arrayListOf<String>().apply{
            add("SPARTIATE")
            add("TATAR")
            add("MULUBULUL")
        }
        adapter.updateList(aoeList)
      /*  code pour naviguer entre les fragments
      view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }
}