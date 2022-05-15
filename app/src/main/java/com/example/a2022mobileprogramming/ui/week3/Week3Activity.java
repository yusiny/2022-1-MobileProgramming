package com.example.a2022mobileprogramming.ui.week3;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
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
        initClickListener();

        /*Examples 클릭 이벤트 리스너*/
        implicitExamples();
        explicitExample();
    }

    /*Practice 이동 이벤트 리스너*/
    private void initClickListener(){
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
    }

    /* Implicit Intent - Examples */
    private void implicitExamples(){

        // 모든 연락처 보기
        binding.week3ContactAllBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(intent);
            }
        });

        // 특정 연락처 보기
        binding.week3ContactParticularBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/1";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(myData));
                startActivity(intent);
            }
        });

        // 특정 연락처 보기 by tel with VIEW, DIAL
        binding.week3TelViewBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                String tel = binding.week3TelEt.getText().toString();

                if(!tel.isEmpty()) {
                    tel = "tel:" + tel;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(tel));
                    startActivity(intent);
                }
            }
       });

        binding.week3TelDialBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                String tel = binding.week3TelEt.getText().toString();

                if(!tel.isEmpty()){
                    tel = "tel:" + tel;
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(tel));
                    startActivity(intent);
                }
            }
        });

        // 연락처 수정
        binding.week3ContactEditBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myData = "content://contacts/people/1";
                Intent intent = new Intent(Intent.ACTION_EDIT, Uri.parse(myData));
                startActivity(intent);
            }
        });

        // 앨범 사진 보기
        binding.week3AlbumBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/pictures/*");
                startActivity(intent);
            }
        });

        // 메시지 보내기
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

        // 웹 검색하기
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

    private void explicitExample(){
        binding.week3NewActivityBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Week3Activity.this, NewActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String name = data.getStringExtra("name");
        Toast.makeText(this, "전닫받은 name 값: "+ name, Toast.LENGTH_SHORT).show();
    }
}
