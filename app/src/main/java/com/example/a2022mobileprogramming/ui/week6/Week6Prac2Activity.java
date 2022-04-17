package com.example.a2022mobileprogramming.ui.week6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.a2022mobileprogramming.R;

public class Week6Prac2Activity extends AppCompatActivity {
    WebView browser;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week6_prac2);

        browser = findViewById(R.id.week6_prac2_webview);

        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.ebay.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_webview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String option = item.getTitle().toString();
        if(option.equals("Forward Page")){
            browser.goForward();
        }
        if(option.equals("Back Page")){
            browser.goBack();
        }

        return super.onOptionsItemSelected(item);
    }
}
