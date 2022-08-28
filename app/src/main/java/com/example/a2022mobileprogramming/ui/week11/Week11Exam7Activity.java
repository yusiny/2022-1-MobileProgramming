package com.example.a2022mobileprogramming.ui.week11;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.R;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class Week11Exam7Activity extends AppCompatActivity {
    Button button;
    EditText editText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam7);

        button = findViewById(R.id.week11_exam7_button);
        editText = findViewById(R.id.week11_exam7_edittext);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String addr = editText.getText().toString().trim();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();

            }
        });

    }

    class ConnectThread extends Thread{
        String hostname;

        public ConnectThread(String addr){
            hostname = addr;
        }

        @Override
        public void run() {
            try{
                int port = 7777;

                Socket socket = new Socket(hostname, port);

                InputStream in  = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                Log.d("MainActivity", "서버에서 받은 메시지: " + dis.readUTF());

                dis.close();
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
