package com.example.a2022mobileprogramming.ui.week11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;
import com.example.a2022mobileprogramming.databinding.ActivityWeek11Binding;
import com.example.a2022mobileprogramming.ui.week10.Week10Exam2Activity;

public class Week11Activity extends AppCompatActivity {
    private ActivityWeek11Binding binding;

    private boolean running;
    private int value;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWeek11Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initOnClickListener();
        exampleThread();
    }

    private void initOnClickListener(){
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

        binding.week11Exam4Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week11Exam4Activity.class));
            }
        });

        binding.week11Exam5Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week11Exam5Activity.class));
            }
        });

        binding.week11Exam6Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week11Exam6Activity.class));
            }
        });
    }

    /*Example - Thread */
    private void exampleThread(){
        Button button = findViewById(R.id.week11_thread_btn);
        TextView textView = findViewById(R.id.week11_thread_tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("스레드에서 받은 값: " + value);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        running = true;
        Thread thread = new BackgroundThread();
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        running = false;
        value = 0;
    }

    class BackgroundThread extends Thread{
        public void run(){
            while(running){
                try{
                    Thread.sleep(1000);
                    value++;
                }catch (Exception e){} // 지정된 시간이 다 되거나 or interrupt 발생 시 InterruptedException 자동 발생되므로, 에러 캐치해주어야 함!
            }
        }
    }
}
