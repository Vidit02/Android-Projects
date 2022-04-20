package com.loginapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginDesign2 extends AppCompatActivity {
    EditText edtEmail,edtPass,edtFirstName,edtLastName;
    Button loginbtn;
    ImageView imgview;
    CircleImageView  proimg;
    LinearLayout imgcamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_design2);
        edtEmail = findViewById(R.id.editemail);
        edtPass  = findViewById(R.id.editpass);
        edtFirstName = findViewById(R.id.editnm);
        edtLastName  = findViewById(R.id.editlastnm);
        loginbtn = findViewById(R.id.signup_btn);
        imgview = findViewById(R.id.edpic);
        proimg = findViewById(R.id.editphoto);

        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.alert_image_acticity,null);
                imgcamera =   myview.findViewById(R.id.camera_btn_clk);
                LinearLayout imggallery = myview.findViewById(R.id.gallery_btn_clk);
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginDesign2.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(myview);
                alertDialog.show();
                imgcamera.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        Intent i = new Intent();
                        i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(i,11);
                    }
                });

                imggallery.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        Intent i = new Intent();
                        i.setAction(Intent.ACTION_PICK);
                        i.setType("image/*");
                        startActivityForResult(i,12);
                    }
                });
            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = edtEmail.getText().toString();
                String passWord = edtPass.getText().toString();
                String firstName = edtFirstName.getText().toString();
                String lastName = edtLastName.getText().toString();
                Intent i = new Intent(LoginDesign2.this , HomeActivity.class);
                i.putExtra("KEY_EMAIL" , "Email id : " + emailid);
                i.putExtra("KEY_PASS" , "Password : " + passWord);
                i.putExtra("KEY_FNAME" , "First Name : " +firstName);
                i.putExtra("KEY_LNAME" , "Last Name : " +lastName);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11){
            Bitmap bit = (Bitmap) data.getExtras().get("data");
            proimg.setImageBitmap(bit);
        }
        if(requestCode == 12 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            proimg.setImageURI(uri);
        }
    }
}