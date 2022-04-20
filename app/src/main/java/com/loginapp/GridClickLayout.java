package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class GridClickLayout extends AppCompatActivity {
    CircleImageView imgview;
    TextView tv_coursedata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_click_layout);
        tv_coursedata = findViewById(R.id.tv_griddata);
        imgview = findViewById(R.id.img_grid_data);
        Intent i = getIntent();
        String strcourse = i.getStringExtra("KEY_VALUENM");
        int img = i.getIntExtra("KEY_VALUEIMG",0);

        tv_coursedata.setText(strcourse);
        imgview.setImageResource(img);
    }
}