package com.example.a2022mobileprogramming.ui.week11;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

public class Week11Exam3Activity extends AppCompatActivity {
    SQLiteDatabase db;
    MySQLiteOpenHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week11_exam3);

        helper = new MySQLiteOpenHelper(Week11Exam3Activity.this, "person.db", null, 1);

        insert("유저1", 18, "홍길동");
        insert("유저2", 28, "홍길동2");
        insert("유저3", 28, "홍길동3");

        update("유저1", 58);
        delete("유저2");
        select();

    }

    public void insert(String name, int age, String address){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("age", age);
        values.put("address", address);

        db.insert("student", null, values); // null: 값이 없으면 넣지 않겠다
    }

    public void update(String name, int age){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("age", age);
        db.update("student", values, "name=?", new String[]{name});
    }

    public void delete(String name){
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        Log.i("db1", name + " 정상적으로 삭제되었습니다. ");
    }

    public void select(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null); // 전부 다 가져오겠다

        while(c.moveToNext()){
            @SuppressLint("Range") int _id = c.getInt(c.getColumnIndex("_id"));
            @SuppressLint("Range") String name = c.getString(c.getColumnIndex("name"));
            @SuppressLint("Range") int age = c.getInt(c.getColumnIndex("age"));
            @SuppressLint("Range") String address = c.getString(c.getColumnIndex("address"));

            Log.i("db1", "id: " + _id + ", name: " + name + ", age: " +  age + ", address: " + address);
        }
    }
}
