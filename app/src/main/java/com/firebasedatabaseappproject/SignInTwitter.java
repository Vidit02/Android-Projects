package com.firebasedatabaseappproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.OAuthProvider;

public class SignInTwitter extends AppCompatActivity {
    Button logintwitter;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_twitter);
        logintwitter = findViewById(R.id.twitterloginbtn);
        mAuth = FirebaseAuth.getInstance();
        logintwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OAuthProvider.Builder provider = OAuthProvider.newBuilder("twitter.com");
                Task<AuthResult> authResultTask = mAuth.getPendingAuthResult();
                if(authResultTask != null){
                    authResultTask.addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignInTwitter.this, "Authentication Failed here", Toast.LENGTH_SHORT).show();

                        }
                    });
                } else{
                    mAuth.startActivityForSignInWithProvider(SignInTwitter.this, provider.build()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Intent i = new Intent(SignInTwitter.this , DisplayActivity.class);
                            startActivity(i);
                            finish();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SignInTwitter.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
    }
}