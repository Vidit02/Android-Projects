package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginNew extends AppCompatActivity {
    EditText edtemail , edtpass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        edtemail = findViewById(R.id.edtemailnew);
        edtpass  = findViewById(R.id.edtpassnew);
        btnLogin = findViewById(R.id.loginbtnnew);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString();
                String pass = edtpass.getText().toString();
                SharedPreferences sharedPreferences = getSharedPreferences("S1",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("EMAIL",email);
                editor.putString("PASS",pass);
                editor.commit();

                edtemail.setText("");
                edtpass.setText("");
                Intent i = new Intent(LoginNew.this, NavActivity.class);
                startActivity(i);
            }
        });
    }
}