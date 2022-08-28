package com.example.a2022mobileprogramming.ui.week11;

import android.os.AsyncTask;
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

public class Week11Exam6Activity extends AppCompatActivity {
    TextView counterTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam6);

        counterTv = findViewById(R.id.week11_exam6_counter_tv);

        new CountDownTask().execute();
    }

    private class CountDownTask extends AsyncTask<Void, Integer, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            counterTv.setText("*START*");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i=0; i<15; i++){
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                }catch (Exception e){}
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            counterTv.setText(Integer.toString(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);

            counterTv.setText("*DONE*");
        }
    }

}
