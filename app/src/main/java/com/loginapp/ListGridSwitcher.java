package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class ListGridSwitcher extends AppCompatActivity {
    ListView listView;
    Button btn;
    String strarr[] = {"Android","Php","Rust","Clojure","Flutter","Spring"};
    boolean isList = true , isGrid = false;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_grid_switcher);
        listView = findViewById(R.id.listviewfind);
        gridView = findViewById(R.id.gridviewfind);
        btn = findViewById(R.id.btnswitch);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_list_item_1,strarr);
        listView.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this ,
                R.layout.list_raw,R.id.tv_data,strarr);
        gridView.setAdapter(arrayAdapter1);

        gridView.setVisibility(View.GONE);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(listView.isShown()){
                    listView.setVisibility(View.GONE);
                    gridView.setVisibility(View.VISIBLE);
                } else{
                    listView.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.GONE);
                }
            }
        });

    }
}