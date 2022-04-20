package com.sqllitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText fname , lname;
    Button addbtn , displaybtn;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        fname = findViewById(R.id.editfname);
        lname = findViewById(R.id.editlname);
        addbtn = findViewById(R.id.addbtn);
        displaybtn = findViewById(R.id.displaybtn);
        db = new DatabaseHandler(this);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstnm = fname.getText().toString();
                String lastnm  = lname.getText().toString();

                Toast.makeText(AddActivity.this, "First Name : " + firstnm, Toast.LENGTH_SHORT).show();
                UserModel userModel = new UserModel();
                userModel.setFirstname(firstnm);
                userModel.setLastname(lastnm);
                db.insertRecord(userModel);
                fname.setText("");
                lname.setText("");
            }
        });

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstnm = fname.getText().toString();
                String lastnm  = lname.getText().toString();
                Intent i = new Intent(AddActivity.this,DisplayActivity.class);
                i.putExtra("KEY_FNAME" , firstnm);
                i.putExtra("KEY_LNAME" , lastnm);
                startActivity(i);
            }
        });
    }
}