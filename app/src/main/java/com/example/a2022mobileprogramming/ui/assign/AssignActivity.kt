package com.example.a2022mobileprogramming.ui.assign

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a2022mobileprogramming.databinding.ActivityAssignBinding
import com.example.a2022mobileprogramming.ui.assign.assign1.Assign1Activity
import com.example.a2022mobileprogramming.ui.assign.assign2.Assign2Activity

class AssignActivity: AppCompatActivity() {
    private lateinit var binding: ActivityAssignBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAssignBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.assign1Btn.setOnClickListener {
            startActivity(Intent(this, Assign1Activity::class.java))
        }

        binding.assign2Btn.setOnClickListener {
            startActivity(Intent(this, Assign2Activity::class.java))
        }
    }
}