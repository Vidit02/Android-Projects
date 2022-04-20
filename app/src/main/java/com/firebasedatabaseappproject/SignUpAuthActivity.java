package com.firebasedatabaseappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpAuthActivity extends AppCompatActivity {
    EditText fname,lname,email,pass,mobnum;
    Button signupbtn,loginbtn;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_auth);
        fname = findViewById(R.id.editnmauth);
        lname = findViewById(R.id.editlastnmauth);
        email = findViewById(R.id.editemailauth);
        pass  = findViewById(R.id.editpassauth);
        mobnum = findViewById(R.id.editmobauth);
        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-databaseappproject-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("AuthUser");
        signupbtn = findViewById(R.id.btn_signup);
        loginbtn = findViewById(R.id.logbtnauth);
        firebaseAuth = FirebaseAuth.getInstance();
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = fname.getText().toString();
                String ln = lname.getText().toString();
                String pas = pass.getText().toString();
                String em = email.getText().toString();
                String mob = mobnum.getText().toString();

                progressDialog = new ProgressDialog(SignUpAuthActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.show();
//                String id = databaseReference.push().getKey();
                firebaseAuth.createUserWithEmailAndPassword(em,pas).addOnCompleteListener(SignUpAuthActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            String userid = firebaseAuth.getUid();
                            UserModel userModel = new UserModel();
                            userModel.setFirstnm(fn);
                            userModel.setLastnm(ln);
                            userModel.setPhonenum(mob);
                            userModel.setEmail(em);
                            userModel.setPass(pas);
                            userModel.setUid(userid);
                            databaseReference.child(userid).setValue(userModel);
                            Intent i = new Intent(SignUpAuthActivity.this,LoginAuthActivity.class);
                            startActivity(i);
                            finish();
                        }
                    }
                });

//
//                databaseReference.child(id).setValue(userModel);
//                fname.setText("");
//                lname.setText("");
//                email.setText("");
//                pass.setText("");
//                mobnum.setText("");

//                Intent i = new Intent(SignUpAuthActivity.this,LoginActivity.class);
//                startActivity(i);
//                finish();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpAuthActivity.this,LoginAuthActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}