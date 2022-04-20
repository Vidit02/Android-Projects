package com.loginapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListShiftView extends AppCompatActivity {
    ListView listView;
    String strarr[] = {"Android","Php","Rust","Clojure","Flutter","Spring"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shift_view);
        listView = findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,strarr){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tvcolor =  (TextView) super.getView(position, convertView, parent);
                if(position%2 == 0){
                    tvcolor.setBackgroundColor(Color.GRAY);
                } else{
                    tvcolor.setBackgroundColor(Color.WHITE);
                }
                return tvcolor;
            }
        };
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strData = parent.getItemAtPosition(position).toString();
                Intent i = new Intent(ListShiftView.this , HomeActivity.class);
                i.putExtra("KEY_ID" , strData);
                startActivity(i);
            }
        });
    }
}