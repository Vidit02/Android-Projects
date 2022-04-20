package com.sqllitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;

public class UpdateActivity extends AppCompatActivity {
    EditText fname , lname ;
    Button updatebtn , deletebtn;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        fname = findViewById(R.id.edtfname);
        lname = findViewById(R.id.edtlname);
        updatebtn = findViewById(R.id.updtbtn);
        deletebtn = findViewById(R.id.deletebtn);

        db = new DatabaseHandler(this);
        Intent i = getIntent();
        String name = i.getStringExtra("FIRSTNAME");
        String userid = i.getStringExtra("USERID");
//        int userid = i.getIntExtra("USERID",0);
        String[] n = name.split(" ");
        fname.setText(n[0]);
        lname.setText(n[1]);
        System.out.println(userid);

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstnm = fname.getText().toString();
                String lastnm  = lname.getText().toString();
                UserModel userModel = new UserModel();
                userModel.setID(userid);
                userModel.setFirstname(firstnm);
                userModel.setLastname(lastnm);
                db.updateRecord(userModel);

                Intent i = new Intent(UpdateActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstnm = fname.getText().toString();
                String lastnm  = lname.getText().toString();
                UserModel userModel = new UserModel();
                userModel.setID(userid);
                userModel.setFirstname(firstnm);
                userModel.setLastname(lastnm);
                db.deleteRecord(userModel);
                Intent i = new Intent(UpdateActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });
    }
}