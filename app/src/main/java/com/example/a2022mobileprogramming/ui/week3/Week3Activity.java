package com.example.a2022mobileprogramming.ui.week3;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.databinding.ActivityWeek3Binding;

public class Week3Activity extends AppCompatActivity {
    private ActivityWeek3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWeek3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /*Practice 이동 이벤트 리스너*/
        binding.week3Prac1Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Prac1Activity.class);
                startActivity(intent);
            }
        });

        binding.week3Prac2Btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Prac2Activity.class);
                startActivity(intent);
            }
        });

        /*클릭 이벤트 리스너*/
        binding.week3ContactAllBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(intent);
            }
        });

        binding.week3ContactParticularBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/1";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(intent);
            }
        });

        binding.week3ContactEditBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/1";
                Intent intent = new Intent(Intent.ACTION_EDIT, Uri.parse(myData));
                startActivity(intent);
            }
        });

        binding.week3AlbumBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/picures/*");
                startActivity(intent);
            }
        });

        binding.week3SendMsgBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메시지 받고 validation
                String msg = binding.week3MsgEt.getText().toString();

                if(!msg.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0105551234"));
                    intent.putExtra("sms_body", msg);
                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(), "메시지를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            }
        });

        binding.week3SearchBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메시지 받고 validation
                String msg = binding.week3SearchEt.getText().toString();

                if(!msg.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, msg);
                    startActivity(intent);
                }else
                    Toast.makeText(getApplicationContext(), "메시지를 입력해 주세요.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
