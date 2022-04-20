package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPreferenceActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editfn , editln;
    Button btnAdd , btnDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        editfn = findViewById(R.id.edtfname);
        editln = findViewById(R.id.edtlname);
        btnAdd = findViewById(R.id.btnadd);
        btnDisplay = findViewById(R.id.btndisplay);
        btnAdd.setOnClickListener(this);
        btnDisplay.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnadd:
                String strFn = editfn.getText().toString();
                String strLn = editln.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("S1",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("FIRST",strFn);
                editor.putString("LAST",strLn);
                editor.commit();

                editln.setText("");
                editfn.setText("");
                break;

            case R.id.btndisplay:
                SharedPreferences sharedPreferences1 = getSharedPreferences("S1",MODE_PRIVATE);
                editfn.setText(sharedPreferences1.getString("FIRST",""));
                editln.setText(sharedPreferences1.getString("FIRST",""));
                break;
        }
    }
}