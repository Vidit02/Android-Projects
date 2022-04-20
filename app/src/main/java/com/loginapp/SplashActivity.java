package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    int time = 3000; //time for delay  --> 3 sec
    GifImageView imggif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        getSupportActionBar().hide();

        imggif = findViewById(R.id.gif_img);
        imggif.setGifImageResource(R.drawable.andgif);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i ;
                SharedPreferences sharedPreferences = getSharedPreferences("S1",MODE_PRIVATE);
                if(sharedPreferences.getString("EMAIL","").equals("")) {
                   i = new Intent(SplashActivity.this, BrowserGalleryOpen.class);
                } else {
                   i = new Intent(SplashActivity.this, BrowserGalleryOpen.class);
                }
                startActivity(i);
                finish(); //used not to go back to that page
            }
        },time);
    }
}