package com.example.a2022mobileprogramming.ui.assign.assign1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.a2022mobileprogramming.R

class Assign1NextAcitivity : AppCompatActivity(){

    private lateinit var urlEt: EditText
    private lateinit var phoneEt: EditText
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assign1_next)

        // Set view for each variables
        urlEt = findViewById(R.id.url_et)
        phoneEt = findViewById(R.id.phone_et)
        backBtn = findViewById(R.id.back_btn)

        // Receive data if intent has extras
        val myBundle = intent.extras
        if(myBundle != null) {
            val name: String = myBundle.getString("name", "")
            val department: String = myBundle.getString("department", "")
            val id: String = myBundle.getString("id", "")

            Toast.makeText(this, "Student Info: $name, $department, $id", Toast.LENGTH_SHORT).show()
        }

        // Click Listener for Back button
        backBtn.setOnClickListener {
            val url = urlEt.text.toString()
            val phone = phoneEt.text.toString()

            if(url != "" && phone != ""){
                if (myBundle != null) {
                    // Put data entered in edit text
                    myBundle.putString("url", url)
                    myBundle.putString("phone", phone)

                    intent.putExtras(myBundle)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }

            }else{
                Toast.makeText(this, "내용을 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}