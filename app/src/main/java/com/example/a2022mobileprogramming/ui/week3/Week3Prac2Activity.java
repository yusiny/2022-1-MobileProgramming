package com.example.a2022mobileprogramming.ui.week3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.databinding.ActivityWeek3Prac2Binding;

public class Week3Prac2Activity extends AppCompatActivity {
    private ActivityWeek3Prac2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek3Prac2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /*Practice 이동 클릭 리스너*/
        binding.week3WebBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        binding.week3CallBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01010001000"));
                startActivity(intent);
            }
        });
    }
}
