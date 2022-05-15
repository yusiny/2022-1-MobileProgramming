package com.example.a2022mobileprogramming.ui.week11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek11Binding;
import com.example.a2022mobileprogramming.ui.week10.Week10Exam2Activity;

public class Week11Activity extends AppCompatActivity {
    private ActivityWeek11Binding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWeek11Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.week11Exam1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week11Exam1Activity.class));
            }
        });

        binding.week11Exam2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week11Exam2Activity.class));
            }
        });

        binding.week11Exam3Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week11Exam3Activity.class));
            }
        });

    }
}
