package com.example.a2022mobileprogramming.ui.week5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;
import com.example.a2022mobileprogramming.databinding.ActivityWeek5Binding;

import java.util.Date;

public class Week5Prac1Activity extends AppCompatActivity {
    TextView labelUserName;
    EditText txtUserName;
    Button btnBegin;
    private Context context;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week5_prac1);

        context = getApplicationContext();

        labelUserName = findViewById(R.id.week5_prac1_tv);
        txtUserName = findViewById(R.id.week5_prac1_et);
        btnBegin = findViewById(R.id.week5_prac1_login_btn);

        btnBegin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                String userName = txtUserName.getText().toString();

                if(userName.compareTo("Yusin Kim") ==0){
                    labelUserName.setText("Ok, Please wait..");
                    Toast.makeText(context, "Hi!, Prof." + userName, duration).show();
                }else{
                    Toast.makeText(context, userName + " is not a valid User", duration).show();
                }

            }
        });

    }

}
