package com.example.a2022mobileprogramming.ui.week2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityMainBinding;
import com.example.a2022mobileprogramming.databinding.ActivityWeek2Binding;


public class Week2Activity extends AppCompatActivity {
    private ActivityWeek2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.week2Prac1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week2Prac1Activity.class);
                startActivity(intent);
            }
        }) ;

        binding.week2Prac2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week2Prac2Activity.class);
                startActivity(intent);
            }
        }) ;

        binding.week2Prac3Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week2Prac3Activity.class);
                startActivity(intent);
            }
        }) ;

        binding.week2Prac4Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week2Prac4Activity.class);
                startActivity(intent);
            }
        }) ;
    }
}
