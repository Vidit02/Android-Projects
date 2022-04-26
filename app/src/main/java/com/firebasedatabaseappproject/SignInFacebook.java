package com.firebasedatabaseappproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.media.FaceDetector;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.Login;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.DeviceLoginButton;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.OAuthProvider;

public class SignInFacebook extends AppCompatActivity {
    CallbackManager callbackManager;
    DeviceLoginButton loginButton;
    private static final String email = "email";
//    private LoginButton logbutton;
//    Button logbutton;
    LoginButton logbutton;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_facebook);
        callbackManager = CallbackManager.Factory.create();
//        LoginButton loginButton = findViewById(R.id.fbloginbtn);
        logbutton = findViewById(R.id.fbloginbtn);
        logbutton.setReadPermissions("email", "public_profile");
        if (AccessToken.isCurrentAccessTokenActive()) {
            startActivity(new Intent(SignInFacebook.this, FacebookDisplayActivity.class));
        }
        logbutton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent i = new Intent(SignInFacebook.this,FacebookDisplayActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(@NonNull FacebookException e) {

            }
        });
    }
    //This is second

//        logbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LoginManager.getInstance().logInWithReadPermissions(SignInFacebook.this , Arrays.asList("public_profile"));
//                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//                    @Override
//                    public void onSuccess(LoginResult loginResult) {
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                startActivity(new Intent(SignInFacebook.this,FacebookDisplayActivity.class));
//                                finish();
//                            }
//                        },2000);
//                    }
//
//                    @Override
//                    public void onCancel() {
//
//                    }
//
//                    @Override
//                    public void onError(@NonNull FacebookException e) {
//
//                    }
//                });
//            }
//        });

//        logbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                LoginManager.getInstance().logInWithReadPermissions(SignInFacebook.this,Arrays.asList("public_profile"));
//                Intent i = new Intent(SignInFacebook.this ,FacebookDisplayActivity.class);
//                startActivity(i);
//                finish();
//            }
//        });
        ///This is one
//        loginButton.setReadPermissions("email","public_profile");
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                handleFacebookAccessToken(loginResult.getAccessToken());
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(@NonNull FacebookException e) {
//
//            }
//        });
//    }
//
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
//
//    private void handleFacebookAccessToken(AccessToken token) {
//        Log.d("Token : ", "handleFacebookAccessToken:" + token);
//
//        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d("Sign in Success : ", "signInWithCred ential:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w("Fail Sign :", "signInWithCredential:failure -- " + task.getException(), task.getException());
//                            Toast.makeText(SignInFacebook.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });

//    private void updateUI(FirebaseUser user) {
//        Intent i = new Intent(SignInFacebook.this , DisplayActivity.class);
//        startActivity(i);
//
//    }
    //        FacebookSdk.sdkInitialize(getApplicationContext());
////        AppEventsLogger.activateApp(this);
//        AppEventsLogger.activateApp(getApplication());
//        callbackManager = CallbackManager.Factory.create();
//        logbutton = (LoginButton) findViewById(R.id.fbloginbtn);
//        logbutton.setReadPermissions("email","public_profile");
//        mAuth = FirebaseAuth.getInstance();
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Intent i = new Intent(SignInFacebook.this,DisplayActivity.class);
//                startActivity(i);
//                finish();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(@NonNull FacebookException e) {
//
//            }
//        });
//        logbutton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                handleFacebookAccessToken(loginResult.getAccessToken());
////                Intent i = new Intent(SignInFacebook.this , DisplayActivity.class);
////                startActivity(i);
////                finish();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(@NonNull FacebookException e) {
//
//            }
//        });
//
//    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
//    }
//
//    private void handleFacebookAccessToken(AccessToken token){
//        Log.e("Logged in token","Successully");
//        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
//        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    Log.e("Log Success","Logged in successfully");
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    Toast.makeText(SignInFacebook.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
//                    updateUI(user);
//                } else {
//                    Log.w("Signincredential",task.getException());
//                    Toast.makeText(SignInFacebook.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
//                    updateUI(null);
//                }
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        callbackManager.onActivityResult(requestCode,resultCode,data);
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//    private void updateUI(FirebaseUser user) {
//



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//        super.onActivityResult(requestCode, resultCode, data);
//    }

}