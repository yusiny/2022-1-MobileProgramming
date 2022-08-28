package com.example.a2022mobileprogramming.ui.week10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.a2022mobileprogramming.R;

public class MyDrawEx extends View {
    public MyDrawEx(Context context) {
        super(context);
    }

    public MyDrawEx(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap sm = BitmapFactory.decodeResource(getResources(), R.drawable.image); // Resource 이미지 -> Bitmap 이미지

        Paint Pnt = new Paint();
        canvas.drawColor(Color.WHITE);

        //Bitmap bitm2 = Bitmap.createBitmap(sm, 0, 0, sm.getWidth()-100, sm.getHeight()-100);
        //canvas.drawBitmap(bitm2, 0,0, Pnt);
        canvas.drawBitmap(sm, new Rect(100, 0, 500, 500), new Rect(0, 0, 400, 500), Pnt);
    }
}
