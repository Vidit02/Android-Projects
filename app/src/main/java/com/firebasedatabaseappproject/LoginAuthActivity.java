package com.firebasedatabaseappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoginAuthActivity extends AppCompatActivity {
    EditText email , password;
    Button lgnbtn,signupbtn;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
//    ArrayList<UserModel> users;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_auth);
        email = findViewById(R.id.lgneditemailauth);
        password = findViewById(R.id.lgneditpassauth);
        lgnbtn = findViewById(R.id.btn_login);
        signupbtn = findViewById(R.id.btn_register);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(LoginAuthActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
//        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-databaseappproject-default-rtdb.asia-southeast1.firebasedatabase.app/");
//        databaseReference = firebaseDatabase.getReference("AuthUser");
        lgnbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ema = email.getText().toString();
                String pas = password.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(ema,pas).addOnCompleteListener(LoginAuthActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            if(progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                            Intent i = new Intent(LoginAuthActivity.this,DisplayAuthActivity.class);
                            String userid = firebaseAuth.getUid();
                            i.putExtra("KEY_UID",userid);
                            startActivity(i);
                            finish();
                        }

                    }
                });
                }

//                databaseReference.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                            UserModel userModel = dataSnapshot1.getValue(UserModel.class);
//                            if(ema.equals(userModel.getEmail()) && pas.equals(userModel.getPass())){
//                                Toast.makeText(LoginAuthActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                            }
//                            else{
//                            }
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                    }
//                });

//            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginAuthActivity.this,SignUpAuthActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}