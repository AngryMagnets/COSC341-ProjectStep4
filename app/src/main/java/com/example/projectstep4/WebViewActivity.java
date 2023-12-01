package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(url);
    }
    public void back(View view){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
}