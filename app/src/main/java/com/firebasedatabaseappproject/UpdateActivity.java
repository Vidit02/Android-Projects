package com.firebasedatabaseappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity {
    EditText fnameedt,lnameedt;
    Button updtbtn,dltbtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent i = getIntent();
        final String pid   = i.getStringExtra("KEY_PID");
        fnameedt = findViewById(R.id.fnameupdt);
        lnameedt = findViewById(R.id.lnameupdt);
        updtbtn = findViewById(R.id.updtbtn);
        dltbtn  = findViewById(R.id.dltbtn);
        fnameedt.setText(i.getStringExtra("KEY_FNAME"));
        lnameedt.setText(i.getStringExtra("KEY_LNAME"));
        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-databaseappproject-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference();

        updtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strFn = fnameedt.getText().toString();
                String strLn = lnameedt.getText().toString();
                PeopleModel peopleModel = new PeopleModel();
                peopleModel.setFirstnm(strFn);
                peopleModel.setLastnm(strLn);
                peopleModel.setUserId(pid);
                databaseReference.child(pid).setValue(peopleModel);
                Intent i = new Intent(UpdateActivity.this,DisplayActivity.class);
                startActivity(i);
                finish();
            }
        });

        dltbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child(pid).removeValue();
                Intent i = new Intent(UpdateActivity.this,DisplayActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}