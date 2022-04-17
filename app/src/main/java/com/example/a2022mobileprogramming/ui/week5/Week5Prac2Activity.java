package com.example.a2022mobileprogramming.ui.week5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

public class Week5Prac2Activity extends AppCompatActivity {
    CheckBox creamCb;
    CheckBox sugarCb;
    RadioGroup coffeeTypeRg;
    RadioButton decafRb;
    RadioButton espressoRb;
    RadioButton colombianRb;
    Button payBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week5_prac2);

        creamCb = findViewById(R.id.week5_cream_cb);
        sugarCb = findViewById(R.id.week5_sugar_cb);

        coffeeTypeRg = findViewById(R.id.week5_radiogroup);
        decafRb = findViewById(R.id.week5_decaf_rb);
        espressoRb = findViewById(R.id.week5_espresso_rb);
        colombianRb = findViewById(R.id.week5_colombian_rb);

        payBtn = findViewById(R.id.week5_pay_btn);
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "Coffee ";

                // Checkbox
                if(creamCb.isChecked())
                    msg += " & cream ";
                if(sugarCb.isChecked())
                    msg += " & sugar ";

                // Radio btn
                int radioId = coffeeTypeRg.getCheckedRadioButtonId();
                if(radioId == decafRb.getId())
                    msg = "Decaf " + msg;
                if(radioId == espressoRb.getId())
                    msg = "Espresso " + msg;
                if(radioId == colombianRb.getId())
                    msg = "Colombian " + msg;

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
