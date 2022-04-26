
package com.firebasedatabaseappproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.se.omapi.Session;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookDisplayActivity extends AppCompatActivity {
    LoginButton btn;
    ImageView imgview;
    TextView tvfbdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_display);
        FacebookSdk.sdkInitialize(getApplicationContext());
        tvfbdata = findViewById(R.id.fbtxt);
        btn = findViewById(R.id.fbbtnlogout);
        imgview = findViewById(R.id.fbprofileimg);
//        AccessToken token = AccessToken.getCurrentAccessToken();
        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(@Nullable JSONObject jsonObject, @Nullable GraphResponse graphResponse) {
                String fname = null;
                try {
                    fname = jsonObject.getString("name");
                    tvfbdata.setText(fname);
                    String pic = jsonObject.getJSONObject("picture").getJSONObject("data").getString("url");
                    Picasso.get().load(pic).into(imgview);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,name,link,picture.type(large)");
        graphRequest.setParameters(bundle);
        graphRequest.executeAsync();
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                LoginManager.getInstance().logOut();
//                startActivity(new Intent(FacebookDisplayActivity.this,SignInFacebook.class));
//                finish();
//            }
//        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Session session = Session.getActiveSession();
//                session.closeAndClearTokenInformation();
                LoginManager.getInstance().logOut();
                Intent i = new Intent(FacebookDisplayActivity.this , SignInFacebook.class);
                startActivity(i);
                finish();
            }
        });
    }


}