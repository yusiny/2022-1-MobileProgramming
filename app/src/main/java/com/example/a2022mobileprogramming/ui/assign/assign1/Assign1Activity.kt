package com.example.a2022mobileprogramming.ui.assign.assign1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.a2022mobileprogramming.R

class Assign1Activity: AppCompatActivity() {
    // variables for Edittext
    private lateinit var nameEt: EditText
    private lateinit var departmentEt: EditText
    private lateinit var idEt: EditText
    private lateinit var disabledUrlEt: EditText
    private lateinit var disabledPhoneEt: EditText

    // variables for Button
    private lateinit var loginBtn: Button
    private lateinit var webBtn: Button
    private lateinit var callBtn: Button

    // variables for uri
    private lateinit var uriWeb: String
    private lateinit var uriPhone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assign1)

        // Set view for each variables
        nameEt = findViewById(R.id.name_et)
        departmentEt = findViewById(R.id.department_et)
        idEt = findViewById(R.id.student_id_et)

        disabledUrlEt = findViewById(R.id.disabled_url_et)
        disabledPhoneEt = findViewById(R.id.disabled_phone_et)

        loginBtn = findViewById(R.id.login_btn)
        webBtn = findViewById(R.id.web_btn)
        callBtn = findViewById(R.id.call_btn)

        setClickListener()
    }

    /*A function to set click listener for each button.*/
    private fun setClickListener() {

        loginBtn.setOnClickListener {
            val name: String = nameEt.text.toString()
            val department: String = departmentEt.text.toString()
            val id: String = idEt.text.toString()

            // Check whether all information are entered
            if(name != "" && department != "" && id != ""){
                val intent = Intent(this@Assign1Activity, Assign1NextAcitivity::class.java)

                val bundle = Bundle()
                bundle.putString("name", name)
                bundle.putString("department", department)
                bundle.putString("id", id)

                intent.putExtras(bundle)
                startActivityForResult(intent, 1122)
            }else{
                Toast.makeText(this, "내용을 모두 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        webBtn.setOnClickListener {

            // Check uri is received -> variable initialized
            if (::uriWeb.isInitialized) {
                if (!uriWeb.contains("http://") && !uriWeb.contains("https://"))
                    uriWeb = "http://$uriWeb"

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriWeb))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Uri가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        callBtn.setOnClickListener {

            // Check uri is received -> variable initialized
            if (::uriPhone.isInitialized) {
                uriPhone = "tel:${uriPhone}"

                val intent = Intent(Intent.ACTION_DIAL, Uri.parse(uriPhone))
                startActivity(intent)
            } else {
                Toast.makeText(this, "전화번호가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            val myBundle = data?.extras
            if(myBundle != null){
                uriWeb = myBundle.getString("url", "")
                uriPhone = myBundle.getString("phone", "")

                disabledUrlEt.setText(uriWeb)
                disabledPhoneEt.setText(uriPhone)
            }
        }
    }
}