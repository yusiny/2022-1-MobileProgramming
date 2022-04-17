package com.example.a2022mobileprogramming.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.a2022mobileprogramming.adapter.MainRVAdapter;
import com.example.a2022mobileprogramming.databinding.ActivityMainBinding;
import com.example.a2022mobileprogramming.model.WeekInfoModel;
import com.example.a2022mobileprogramming.ui.week2.Week2Activity;
import com.example.a2022mobileprogramming.ui.week3.Week3Activity;
import com.example.a2022mobileprogramming.ui.week5.Week5Activity;
import com.example.a2022mobileprogramming.ui.week6.Week6Activity;


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

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRVAdapter.setLayoutManager(layoutManager);
        mainRVAdapter.setAdapter(adapter);

        adapter.setOnItemClickListener(new MainRVAdapter.OnItemClickListener() {
            @Override
            public void onItemclick(View v, int position) {
                startNextActivity(position);
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
            default:
                return;
        }

        startActivity(intent);
    }
}