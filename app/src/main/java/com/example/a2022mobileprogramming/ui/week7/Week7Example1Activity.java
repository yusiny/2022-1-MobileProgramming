package com.example.a2022mobileprogramming.ui.week7;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week7Example1Activity extends AppCompatActivity {

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

            Paint pnt = new Paint();
            pnt.setColor(Color.BLUE);

            /* 원 그리기 */
            canvas.drawCircle(300, 150, 50, pnt);

            /* 사각형 그리기 */
            canvas.drawRect(100, 100, 200, 200, pnt);

            /* Paint test */
            Paint pnt2 = new Paint(Paint.ANTI_ALIAS_FLAG);
            pnt2.setStrokeWidth(8);
            pnt2.setColor(Color.RED);

            // FILL
            pnt2.setStyle(Paint.Style.FILL);
            canvas.drawCircle(100, 300, 40, pnt2);

            // STROKE
            pnt2.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(200, 300, 40, pnt2);

            // FILL AND STROKE
            pnt2.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(300, 300, 40, pnt2);

            // 1. 채우고 -> 2. 선
            pnt2.setColor(Color.BLUE);
            pnt2.setStyle(Paint.Style.FILL);
            canvas.drawCircle(100, 400, 40, pnt2);

            pnt2.setColor(Color.RED);
            pnt2.setStyle(Paint.Style.FILL);
            canvas.drawCircle(100, 400, 40, pnt2);

            // 1. 선 -> 2. 채우기
            pnt2.setColor(Color.RED);
            pnt2.setStyle(Paint.Style.FILL);
            canvas.drawCircle(200, 400, 40, pnt2);

            pnt2.setColor(Color.BLUE);
            pnt2.setStyle(Paint.Style.FILL);
            canvas.drawCircle(200, 400, 40, pnt2);

            /* 캡모양 테스트 */
            Paint pnt3 = new Paint(Paint.ANTI_ALIAS_FLAG);

            pnt3.setColor(Color.BLUE);
            pnt3.setStrokeWidth(16);

            // Default
            canvas.drawLine(50, 500, 240, 500, pnt3);


            // Round
            pnt3.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50, 550, 240, 550, pnt3);

            // Square
            pnt3.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawLine(50, 600, 240, 600, pnt3);

            /* Join 모양 테스트 */
            Paint pnt4 = new Paint(Paint.ANTI_ALIAS_FLAG);

            pnt4.setColor(Color.BLACK);
            pnt4.setStrokeWidth(20);
            pnt4.setStyle(Paint.Style.STROKE);

            // Mitter
            pnt4.setStrokeJoin(Paint.Join.MITER);
            canvas.drawRect(50, 700, 90, 750, pnt4);

            // Bevel
            pnt4.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawRect(120, 700, 160, 750, pnt4);

            // Round
            pnt4.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawRect(190, 700, 230, 750, pnt4);
        }
    }
}
