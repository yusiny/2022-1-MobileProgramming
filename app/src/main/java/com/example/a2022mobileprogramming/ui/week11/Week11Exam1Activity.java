package com.example.a2022mobileprogramming.ui.week11;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.R;

public class Week11Exam1Activity extends AppCompatActivity {
    Button submit, exit;
    String username, password;
    EditText userInput, passInput;
    SharedPreferences spf;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam1);

        submit = findViewById(R.id.week11_submit_btn);
        exit = findViewById(R.id.week11_exit_btn);
        userInput = findViewById(R.id.week11_user_et);
        passInput = findViewById(R.id.week11_user_pw_et);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                username = userInput.getText().toString();
                password = passInput.getText().toString();

                sharedPreference();

                Toast.makeText(getApplicationContext(), "Details are saved", Toast.LENGTH_SHORT).show();
            }
        });

        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        applySharedPreference();
    }

    public void sharedPreference(){
        spf = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = spf.edit();

        toEdit.putString("Username", username);
        toEdit.putString("Password", password);

        toEdit.commit();
    }

    public void applySharedPreference(){
        spf = getSharedPreferences("Login Credentials", MODE_PRIVATE);

        if(spf != null && spf.contains("Username")){
            String name = spf.getString("Username", "noname");
            userInput.setText(name);
        }
    }
}
