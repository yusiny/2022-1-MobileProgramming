package com.example.a2022mobileprogramming.ui.assign.assign2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.a2022mobileprogramming.R


class Assign2MainFragment: Fragment(){
    private val days = arrayListOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_assign2_main, container, false) as ViewGroup

        val listView: ListView = rootView.findViewById(R.id.assign2_listview)
        val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, days)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(requireContext(), days[position], Toast.LENGTH_SHORT).show()
        }

        return rootView
    }
}