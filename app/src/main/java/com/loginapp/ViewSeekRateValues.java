package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewSeekRateValues extends AppCompatActivity {
    TextView ratenum , seeknum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_seek_rate_values);

        ratenum = findViewById(R.id.tv_ratenum);
        seeknum = findViewById(R.id.tv_seekrate);
        Intent i = getIntent();
        String rnum = i.getStringExtra("KEY_RATE");
        String snum = i.getStringExtra("KEY_SEEK");
        ratenum.setText(rnum);
        seeknum.setText(snum);
    }
}