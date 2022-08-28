package com.example.a2022mobileprogramming.ui.week13;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a2022mobileprogramming.R;

import java.util.List;

public class Week13Activity extends AppCompatActivity {
    TextView mTxt1;
    SensorManager mSM;
    Sensor myGravity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week13);

        mTxt1 = findViewById(R.id.week13_textview2);
        mSM = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        myGravity = mSM.getDefaultSensor(Sensor.TYPE_GRAVITY);
        mSM.registerListener(mySensorListener, myGravity, SensorManager.SENSOR_DELAY_NORMAL);

        List<Sensor> arSensor = mSM.getSensorList(Sensor.TYPE_ALL);
        String result = " 갯수 : " + arSensor.size() + "\n\n";
        for(Sensor s: arSensor){
            result += (" 이름 = " + s.getName() + ",\n 형식 = " + s.getType() + ",\n 제조사 = " + s.getVendor() + ",\n 전원 = " + s.getPower()
                    + ",\n 해상도 = " + s.getResolution() + ",\n 범위 = " + s.getMaximumRange() + "\n\n") ;
        }

        TextView txtResut = findViewById(R.id.week13_result);
        txtResut.setText(result);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mSM.registerListener(mySensorListener, myGravity, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSM.unregisterListener(mySensorListener);
    }

    public SensorEventListener mySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(sensorEvent.sensor.getType() == Sensor.TYPE_GRAVITY){
                mTxt1.setText(Float.toString(sensorEvent.values[0]));
                Log.i("TAG", Float.toString(sensorEvent.values[0]));
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}
