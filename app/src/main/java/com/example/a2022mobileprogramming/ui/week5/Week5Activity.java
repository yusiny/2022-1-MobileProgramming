package com.example.a2022mobileprogramming.ui.week5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek5Binding;
import java.util.Date;

public class Week5Activity extends AppCompatActivity {
    private ActivityWeek5Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek5Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setMyClickListener();
        service();
        eventListener();
    }

    /*Default 클릭 리스너*/
    private void setMyClickListener(){
        binding.week5Prac1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week5Prac1Activity.class));
            }
        });

        binding.week5Prac2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week5Prac2Activity.class));
            }
        });

        binding.week5Assign1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week5AssignActivity.class));
            }
        });

        binding.week5MenuExampleBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week5Exam1Activity.class));
            }
        });
    }

    /*[Example] Service*/
    private void service() {
        binding.week5StartServiceBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        });

        binding.week5StopServiceBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(getApplicationContext(), MyService.class));
            }
        });
    }

    private void eventListener() {
        binding.myButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTime();
            }
        });
    }

    private void updateTime(){
        binding.myButton.setText(new Date().toString());
    }
}
