package com.firebasedatabaseappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {
    EditText fname,lname,email,pass,mobnum;
    Button signupbtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fname = findViewById(R.id.editnm);
        lname = findViewById(R.id.editlastnm);
        email = findViewById(R.id.editemail);
        pass  = findViewById(R.id.editpass);
        mobnum = findViewById(R.id.editmob);
        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-databaseappproject-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("User");
        signupbtn = findViewById(R.id.signupbtn);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = fname.getText().toString();
                String ln = lname.getText().toString();
                String pas = pass.getText().toString();
                String em = email.getText().toString();
                String mob = mobnum.getText().toString();
                String id = databaseReference.push().getKey();
                UserModel userModel = new UserModel();
                userModel.setFirstnm(fn);
                userModel.setLastnm(ln);
                userModel.setPhonenum(mob);
                userModel.setEmail(em);
                userModel.setPass(pas);
                userModel.setUid(id);

                databaseReference.child(id).setValue(userModel);
                fname.setText("");
                lname.setText("");
                email.setText("");
                pass.setText("");
                mobnum.setText("");

                Intent i = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}