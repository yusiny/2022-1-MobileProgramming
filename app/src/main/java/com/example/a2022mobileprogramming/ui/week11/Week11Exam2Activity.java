package com.example.a2022mobileprogramming.ui.week11;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Week11Exam2Activity extends AppCompatActivity {
    private final static String NOTES = "notes.txt";
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam2);

        editText = findViewById(R.id.week11_exam2_et);
        Button btn = findViewById(R.id.week11_exam2_save_and_exit_btn);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        try{
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(NOTES, 0)); // MODE_PRIVATE
            out.write(editText.getText().toString());
            out.close();
        }catch (Throwable t){
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        try{
            InputStream in = openFileInput(NOTES);
            if(in != null){
                BufferedReader reader = new BufferedReader((new InputStreamReader(in)));
                String str = "";
                StringBuffer buf = new StringBuffer();

                while((str = reader.readLine()) != null){
                    buf.append(str + "\n");
                }
                in.close();

                editText.setText(buf.toString());
            }
        }catch (java.io.FileNotFoundException e){
        }catch (Throwable t){
            Toast.makeText(getApplicationContext(), "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
