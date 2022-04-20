package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Videoview extends AppCompatActivity {
    VideoView video;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoview);

        video = findViewById(R.id.videoview);
        String strpath = "android.resource://" +
                getPackageName() + "/" + R.raw.car_video;
        video.setVideoPath(strpath);
        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        video.start();
    }
}