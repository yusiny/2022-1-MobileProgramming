package com.example.a2022mobileprogramming.ui.week10;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek10Binding;


public class Week10Activity extends AppCompatActivity {
    private ActivityWeek10Binding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWeek10Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.week10Exam1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week10Exam1Activity.class));
            }
        });

        TransitionDrawable drawable = (TransitionDrawable) binding.week10ImgButton.getDrawable();
        drawable.startTransition(5000);

        binding.week10Exam2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week10Exam2Activity.class));
            }
        });

        binding.week10Exam3Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week10Exam3Activity.class));
            }
        });
    }
}
