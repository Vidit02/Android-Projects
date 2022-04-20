package com.sqllitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginDesign2 extends AppCompatActivity {

    private EditText firstnm;
    private EditText lastnm;
    private EditText emailid;
    private EditText passw;
    private Button signupbtn;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_design2);
        firstnm = findViewById(R.id.editfirstname);
        lastnm = findViewById(R.id.editlastname);
        emailid = findViewById(R.id.editemail);
        passw = findViewById(R.id.editpass);
        signupbtn = findViewById(R.id.signup_btn);
        db = new DatabaseHandler(this);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String fname = firstnm.getText().toString();
                        String lname = lastnm.getText().toString();
                        String email = emailid.getText().toString();
                        String pass = passw.getText().toString();
                        User1Model user1Model = new User1Model();
                        user1Model.setFirstname(fname);
                        user1Model.setLastname(lname);
                        user1Model.setEmail(email);
                        user1Model.setPassword(pass);
                        db.insertRecordUser(user1Model);
                    }
                });
            }
        });
    }
}