package com.example.projectstep4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

    }
    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void map(View view){
    }

    public void news1(View view){
        Intent intent = new Intent(this, WebViewActivity.class);
        Bundle extras = new Bundle();
        extras.putString("url", "https://www.cbc.ca/news/canada/british-columbia/kelowna-airport-airspace-closed-wildfires-1.6940699");
        intent.putExtras(extras);
        startActivity(intent);
    }
    public void news2(View view){
        Intent intent = new Intent(this, WebViewActivity.class);
        Bundle extras = new Bundle();
        extras.putString("url", "https://globalnews.ca/news/9809968/knox-mountain-fire-hazards-update/");
        intent.putExtras(extras);
        startActivity(intent);
    }
    public void news3(View view){
        Intent intent = new Intent(this, WebViewActivity.class);
        Bundle extras = new Bundle();
        extras.putString("url", "https://www.kelownacapnews.com/news/4-7-magnitude-earthquake-shakes-east-of-b-c-possible-aftershock-of-2012-quake-4398412");
        intent.putExtras(extras);
        startActivity(intent);
    }
}