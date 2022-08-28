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

/* Handler 1 - Handler 만들기 */
public class Week11Exam4Activity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    ProgressHandler progressHandler;
    boolean isRunning;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam4);

        textView = findViewById(R.id.week11_exam4_working_tv);
        progressBar = findViewById(R.id.week11_exam4_working_pb);

        progressHandler = new ProgressHandler(); // 핸들러 생성
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
                        Message msg = progressHandler.obtainMessage();
                        progressHandler.sendMessage(msg);
                    }
                }catch (Exception e){}
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

    public class ProgressHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            progressBar.incrementProgressBy(5);

            if(progressBar.getProgress() == progressBar.getMax())
                textView.setText("Done");
            else
                textView.setText("Working..." + progressBar.getProgress());
        }
    }
}
