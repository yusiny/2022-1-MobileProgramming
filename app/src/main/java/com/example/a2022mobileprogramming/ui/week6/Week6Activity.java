package com.example.a2022mobileprogramming.ui.week6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;
import com.example.a2022mobileprogramming.databinding.ActivityWeek6Binding;
import com.example.a2022mobileprogramming.ui.week6.fragment.Week6MainFragment;
import com.example.a2022mobileprogramming.ui.week6.fragment.Week6MenuFragment;

public class Week6Activity extends AppCompatActivity {
    private ActivityWeek6Binding binding;

    Week6MainFragment mainFragment;
    Week6MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek6Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setMyClickListener();
        exampleFragment();
        exampleListView();
    }

    /*Default 클릭 리스너*/
    private void setMyClickListener(){
        binding.week6Prac1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week6Prac1Activity.class));
            }
        });

        binding.week6Prac2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week6Prac2Activity.class));
            }
        });

        binding.week6Prac3Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Week6Prac3Activity.class));
            }
        });
    }

    /*Example: Fragment*/
    private void exampleFragment(){
        mainFragment = new Week6MainFragment();
        menuFragment = new Week6MenuFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.week6_fragment_container, mainFragment).commit();
    }

    public void onFragmentChanged(int index){
        if(index == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.week6_fragment_container, menuFragment).commit();
        }else if(index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.week6_fragment_container, mainFragment).commit();
        }
    }

    /*Example: ListView*/
    private void exampleListView(){
        String[] names = {"LEE", "CHOI", "KIM", "JEONG", "RHO"};
        ListView listView = findViewById(R.id.week6_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);
    }
}
