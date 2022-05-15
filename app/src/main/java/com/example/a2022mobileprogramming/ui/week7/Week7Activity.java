package com.example.a2022mobileprogramming.ui.week7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek7Binding;
import com.example.a2022mobileprogramming.ui.week6.Week6Prac2Activity;
import com.example.a2022mobileprogramming.ui.week6.fragment.Week6MainFragment;
import com.example.a2022mobileprogramming.ui.week6.fragment.Week6MenuFragment;

public class Week7Activity extends AppCompatActivity {
    private ActivityWeek7Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek7Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setMyClickListener();
    }

    /*Default 클릭 리스너*/
    private void setMyClickListener(){
        binding.week7Prac1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week7Prac1Activity.class));
            }
        });

        binding.week7Exam1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week7Example1Activity.class));
            }
        });

        binding.week7Exam2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week7Example2Activity.class));
            }
        });
    }
}
