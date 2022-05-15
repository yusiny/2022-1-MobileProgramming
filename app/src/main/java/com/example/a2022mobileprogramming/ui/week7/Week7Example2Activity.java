package com.example.a2022mobileprogramming.ui.week7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week7Example2Activity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView vm = new MyView(this);
        setContentView(vm); //여기서 연결해줌
    }

    protected class MyView extends View {
        public MyView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Path path = new Path();
            canvas.drawColor(Color.WHITE);

            Paint pnt = new Paint();
            pnt.setColor(Color.RED);
            pnt.setStrokeWidth(5);
            pnt.setStyle(Paint.Style.STROKE);

            // Rect, Circle path에 추가 -> draw
            path.addRect(100, 0, 150, 90, Path.Direction.CW);
            path.addCircle(50, 50, 40, Path.Direction.CW);
            canvas.drawPath(path, pnt);

            // 라인 path에 저장 -> draw
            path.reset();
            path.moveTo(10, 110);
            path.lineTo(50, 150);
            path.lineTo(400, 10);

            pnt.setStrokeWidth(3);
            pnt.setColor(Color.BLUE);

            canvas.drawPath(path, pnt);

            // 텍스트
            pnt.setTextSize(20);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("Text on Path.", path, 0, 0, pnt);
        }
    }
}
