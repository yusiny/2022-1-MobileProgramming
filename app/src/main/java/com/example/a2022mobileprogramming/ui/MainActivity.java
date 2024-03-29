package com.example.a2022mobileprogramming.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a2022mobileprogramming.adapter.MainRVAdapter;
import com.example.a2022mobileprogramming.databinding.ActivityMainBinding;
import com.example.a2022mobileprogramming.model.WeekInfoModel;
import com.example.a2022mobileprogramming.ui.assign.AssignActivity;
import com.example.a2022mobileprogramming.ui.week10.Week10Activity;
import com.example.a2022mobileprogramming.ui.week11.Week11Activity;
import com.example.a2022mobileprogramming.ui.week12.Week12Activity;
import com.example.a2022mobileprogramming.ui.week13.Week13Activity;
import com.example.a2022mobileprogramming.ui.week2.Week2Activity;
import com.example.a2022mobileprogramming.ui.week3.Week3Activity;
import com.example.a2022mobileprogramming.ui.week5.Week5Activity;
import com.example.a2022mobileprogramming.ui.week6.Week6Activity;
import com.example.a2022mobileprogramming.ui.week7.Week7Activity;
import com.example.a2022mobileprogramming.ui.week9.Week9Activity;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RecyclerView mainRVAdapter = binding.mainRv;
        MainRVAdapter adapter = new MainRVAdapter();
        adapter.addItem(new WeekInfoModel(2, "View and Layouts"));
        adapter.addItem(new WeekInfoModel(3, "Lifecycle of Activity"));
        adapter.addItem(new WeekInfoModel(5, "Widgets and Event"));
        adapter.addItem(new WeekInfoModel(6, "Widgets and Event - Advanced"));
        adapter.addItem(new WeekInfoModel(7, "Graphic and Animation (1)"));
        adapter.addItem(new WeekInfoModel(9, "Kotlin"));
        adapter.addItem(new WeekInfoModel(10, "Graphic and Animation (2)"));
        adapter.addItem(new WeekInfoModel(11, "Data (Spf, File, SQLite)"));
        adapter.addItem(new WeekInfoModel(12, "Multimedia and Location Service "));
        adapter.addItem(new WeekInfoModel(13, "Sensor "));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRVAdapter.setLayoutManager(layoutManager);
        mainRVAdapter.setAdapter(adapter);

        adapter.setOnItemClickListener(new MainRVAdapter.OnItemClickListener() {
            @Override
            public void onItemclick(View v, int position) {
                startNextActivity(position);
            }
        });

        binding.mainAssignBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AssignActivity.class));
            }
        });
    }

    private void startNextActivity(int code){
        Intent intent;
        switch (code){
            case 0:
                intent = new Intent(this, Week2Activity.class);
                break;
            case 1:
                intent = new Intent(this, Week3Activity.class);
                break;
            case 2:
                intent = new Intent(this, Week5Activity.class);
                break;
            case 3:
                intent = new Intent(this, Week6Activity.class);
                break;
            case 4:
                intent = new Intent(this, Week7Activity.class);
                break;
            case 5:
                intent = new Intent(this, Week9Activity.class);
                break;
            case 6:
                intent = new Intent(this, Week10Activity.class);
                break;
            case 7:
                intent = new Intent(this, Week11Activity.class);
                break;
            case 8:
                intent = new Intent(this, Week12Activity.class);
                break;
            case 9:
                intent = new Intent(this, Week13Activity.class);
                break;
            default:
                return;
        }

        startActivity(intent);
    }
}