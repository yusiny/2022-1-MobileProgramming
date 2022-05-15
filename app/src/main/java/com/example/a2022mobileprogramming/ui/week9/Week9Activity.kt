package com.example.a2022mobileprogramming.ui.week9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a2022mobileprogramming.databinding.ActivityWeek9Binding

class Week9Activity : AppCompatActivity() {
    private lateinit var binding: ActivityWeek9Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeek9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var count: Int = 0
        binding.week9Textview.text = count.toString()

        binding.week9Button.setOnClickListener {
            count++
            binding.week9Textview.text = count.toString()
        }
    }

}