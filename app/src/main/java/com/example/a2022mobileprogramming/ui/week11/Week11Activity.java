package com.example.a2022mobileprogramming.ui.week11;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek11Binding;

public class Week11Activity extends AppCompatActivity {
    private ActivityWeek11Binding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWeek11Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
}
