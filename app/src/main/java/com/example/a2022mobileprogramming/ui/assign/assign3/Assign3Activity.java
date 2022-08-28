package com.example.a2022mobileprogramming.ui.assign.assign3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

public class Assign3Activity extends AppCompatActivity {
    TextView timeTv;

    Button recordBtn;
    Button pauseBtn;
    Button stopBtn;

    Button startBtn;
    Button moreBtn;

    RelativeLayout btnsLayout;
    LinearLayout controlBtnsLayout;

    int time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign3);

        timeTv = findViewById(R.id.time_tv);
        recordBtn = findViewById(R.id.record_btn);
        pauseBtn = findViewById(R.id.pause_btn);
        stopBtn = findViewById(R.id.stop_btn);

        startBtn = findViewById(R.id.start_btn);
        moreBtn = findViewById(R.id.more_btn);

        btnsLayout = findViewById(R.id.buttons_layout);
        controlBtnsLayout = findViewById(R.id.control_buttons_layout);


    }

    public class TimerRunnable implements Runnable{
        public void run(){
            
        }
    }
}
