package com.loginapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarRatingBar extends AppCompatActivity {

    private static final String TAG = SeekBarRatingBar.class.getName();
    private SeekBar seekBar;
    private TextView tvSeek;
    private RatingBar rateBar;
    private TextView tvRate;
    Button viewval;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_rating_bar);

        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        seekBar.setMax(500);
        seekBar.setMin(200);
        tvSeek  = (TextView) findViewById(R.id.seekchange);
        rateBar = (RatingBar) findViewById(R.id.rating_bar);
        tvRate  = (TextView) findViewById(R.id.ratechange);
        viewval    = findViewById(R.id.view_btn);

        viewval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int Seekratenum = Integer.parseInt(tvSeek.getText().toString());
                float Ratenum = Float.parseFloat(tvRate.getText().toString());
                Intent i = new Intent(SeekBarRatingBar.this , ViewSeekRateValues.class);
                i.putExtra("KEY_SEEK" , "SeekBar number is :" + Seekratenum);
                i.putExtra("KEY_RATE" , "RateBar number is :" + Ratenum);
                startActivity(i);
            }
        });

        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvRate.setText(String.valueOf(rating));
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e(TAG , "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e(TAG , "onStartTrackingTouch");
            }
        });
    }
}