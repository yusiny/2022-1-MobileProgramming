package com.example.a2022mobileprogramming.ui.week11;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

/* Handler 2 - Runnable 객체 자체(코드)를 넘기기   */
public class Week11Exam5Activity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    Handler handler;
    ProgressRunnable progressRunnable;
    boolean isRunning;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam5);

        textView = findViewById(R.id.week11_exam5_working_tv);
        progressBar = findViewById(R.id.week11_exam5_working_pb);

        handler = new Handler();
        progressRunnable = new ProgressRunnable();
    }

    @Override
    protected void onStart() {
        super.onStart();

        progressBar.setProgress(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(int i=0; i<20 && isRunning; i++){
                        Thread.sleep(1000);
                        handler.post(progressRunnable);
                    }
                }catch (Exception e) {
                    Log.e("Week11Exam5", "Exception in processing msg " + e);
                }
            }
        });

        isRunning = true;
        thread.start();
    }

    @Override
    protected void onStop() {
        super.onStop();

        isRunning = false;
    }

    public class ProgressRunnable implements Runnable{
        @Override
        public void run() {
            progressBar.incrementProgressBy(5);

            if(progressBar.getProgress() == progressBar.getMax())
                textView.setText("Done");
            else
                textView.setText("Working..." + progressBar.getProgress());
        }
    }
}
