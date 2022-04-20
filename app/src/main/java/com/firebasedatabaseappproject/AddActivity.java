package com.firebasedatabaseappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {
    EditText fnamedt,lnamedt;
    Button addbtn,displaybtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        fnamedt = findViewById(R.id.fnameedt);
        lnamedt = findViewById(R.id.lnameedt);
        addbtn  = findViewById(R.id.addbtn);
        displaybtn = findViewById(R.id.displaybtn);
        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-databaseappproject-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("People");
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = fnamedt.getText().toString();
                String lname = lnamedt.getText().toString();
                Toast.makeText(AddActivity.this, fname + " " + lname, Toast.LENGTH_SHORT).show();
                String userid = databaseReference.push().getKey();
                PeopleModel peopleModel = new PeopleModel();
                peopleModel.setFirstnm(fname);
                peopleModel.setLastnm(lname);
                peopleModel.setUserId(userid);
                databaseReference.child(userid).setValue(peopleModel);
                fnamedt.setText("");
                lnamedt.setText("");
            }
        });

        displaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddActivity.this,DisplayActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}