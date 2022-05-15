package com.example.a2022mobileprogramming.ui.assign.assign2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.a2022mobileprogramming.R

class Assign2MenuFragment: Fragment(){
    private val lectures = arrayListOf("데이터 과학", "모바일 프로그래밍", "소프트웨어공학", "경영학원론", "소프트웨어산업세미나", "졸업작품 1")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_assign2_menu, container, false) as ViewGroup

        val spinner: Spinner = rootView.findViewById(R.id.assign2_spinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, lectures)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.setSelection(1)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, i: Int, l: Long) {
                Toast.makeText(activity, "${lectures[i]}(이)가 선택되었습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }

        return rootView
    }
}