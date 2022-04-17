package com.example.a2022mobileprogramming.ui.week2;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek2Prac4Binding;

public class Week2Prac4Activity extends AppCompatActivity {
    private ActivityWeek2Prac4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek2Prac4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}
