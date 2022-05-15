package com.example.a2022mobileprogramming.ui.assign.assign2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.a2022mobileprogramming.R

class Assign2Activity: AppCompatActivity() {
    private lateinit var mainFragment: Assign2MainFragment
    private lateinit var menuFragment: Assign2MenuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assign2)

        mainFragment = Assign2MainFragment()
        menuFragment = Assign2MenuFragment()

        supportFragmentManager.beginTransaction().replace(R.id.assign2_fragment_container, mainFragment).commit()

        val mainBtn: Button = findViewById(R.id.assign2_main_btn)
        val menuBtn: Button = findViewById(R.id.assign2_menu_btn)

        mainBtn.setOnClickListener {
            goTo(0)
        }
        menuBtn.setOnClickListener {
            goTo(1)
        }

    }

    // 0 - Main, 1 - Menu
    private fun goTo(dest: Int){
        if(dest == 0){ // Main
            supportFragmentManager.beginTransaction().replace(R.id.assign2_fragment_container, mainFragment).commit()
        }else if(dest == 1){ // Menu
            supportFragmentManager.beginTransaction().replace(R.id.assign2_fragment_container, menuFragment).commit()
        }
    }
}