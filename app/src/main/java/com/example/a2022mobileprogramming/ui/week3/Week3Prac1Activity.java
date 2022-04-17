package com.example.a2022mobileprogramming.ui.week3;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

public class Week3Prac1Activity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week3_prac1);

        container = (LinearLayout) findViewById(R.id.container);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_sub, container, true);

                CheckBox checkBox = (CheckBox) container.findViewById(R.id.sub1_cb);
                checkBox.setText("로딩되었어요.");
            }
        });
    }
}
