package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtEmail,edtPass;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.inp_email);
        edtPass = findViewById(R.id.inp_pass);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String emailId = edtEmail.getText().toString();
                    String passWord = edtPass.getText().toString();
                    if(emailId.equals("")){
                        edtEmail.setError("Enter email id");
                    }
                    else if (passWord.equals("")){
                        edtPass.setError("Enter password");
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Email Id is : " + emailId + "\nPassword is : " + passWord, Toast.LENGTH_SHORT).show();
                    }
                Intent i = new Intent(MainActivity.this , HomeActivity.class);
                i.putExtra("KEY_EMAIL" , emailId);
                startActivity(i);
            }
        });
    }
}