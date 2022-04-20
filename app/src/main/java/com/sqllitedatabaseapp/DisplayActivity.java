package com.sqllitedatabaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView = findViewById(R.id.list_view);
        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<UserModel> users = db.getAllRecords();
        String fnamearr[] = new String[users.size()];
        String lnamearr[] = new String[users.size()];
        String useridarr[] = new String[users.size()];
        int j=0;
        for(UserModel i : users){
            fnamearr[j] = i.getFirstname();
            lnamearr[j] = i.getLastname();
            useridarr[j] = i.getID() ;
            j++;
        }
        String[] finalArray = new String[fnamearr.length];
        for(int i = 0; i< fnamearr.length; ++i) {
            finalArray[i] = fnamearr[i] + " " + lnamearr[i] ;
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, finalArray);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i =  new Intent(DisplayActivity.this , UpdateActivity.class);
                i.putExtra("FIRSTNAME" , finalArray[position]);
                i.putExtra("USERID" , useridarr[position]);
                startActivity(i);
            }
        });
    }
}