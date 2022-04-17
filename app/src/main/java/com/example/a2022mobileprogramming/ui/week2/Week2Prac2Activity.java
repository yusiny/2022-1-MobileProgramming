package com.example.a2022mobileprogramming.ui.week2;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek2Prac2Binding;

public class Week2Prac2Activity extends AppCompatActivity {
    private ActivityWeek2Prac2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek2Prac2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}
