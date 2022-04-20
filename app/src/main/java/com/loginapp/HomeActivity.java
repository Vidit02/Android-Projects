package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    TextView tvEmail,tvPass,tvFirstnm,tvLastnm,tvcourse,tvcoursegrid;
    CircleImageView imgview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvEmail = findViewById(R.id.tv_email);
        tvPass = findViewById(R.id.tv_pass);
        tvFirstnm = findViewById(R.id.tv_fname);
        tvLastnm = findViewById(R.id.tv_lname);
        tvcourse = findViewById(R.id.tv_course);
        tvcoursegrid = findViewById(R.id.tv_coursegrid);
        imgview = findViewById(R.id.imgdata_circle);
        Intent i = getIntent();
        String strEmail = i.getStringExtra("KEY_EMAIL");
        String strPass = i.getStringExtra("KEY_PASS");
        String strFirstnm = i.getStringExtra("KEY_FNAME");
        String course = i.getStringExtra("KEY_ID");
        String strLastnm = i.getStringExtra("KEY_LNAME");
        String strcourse = i.getStringExtra("KEY_VALUENM");
        int img = i.getIntExtra("KEY_VALUEIMG",0);
        tvFirstnm.setText(strFirstnm);
        tvLastnm.setText(strLastnm);
        tvEmail.setText(strEmail);
        tvPass.setText(strPass);
        tvcourse.setText(course);
        tvcoursegrid.setText(strcourse);
        imgview.setImageResource(img);
    }
}