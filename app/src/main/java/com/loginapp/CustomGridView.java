package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CustomGridView extends AppCompatActivity {
    ArrayList<LangModel> langModelArrayList;
    GridView gridView;
    String strarr[] = {"Android","Php","Java","iOS","C","C++","Python"};
    int imgLang[] = {R.mipmap.ic_launcher_round, R.drawable.ic_php, R.drawable.ic_java, R.drawable.ic_ios , R.drawable.ic_c,R.drawable.ic_cc , R.drawable.ic_python};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid_view);
        gridView = findViewById(R.id.custgridview);

        langModelArrayList = new ArrayList<LangModel>();
        for(int i=0 ; i<strarr.length ; i++){
            LangModel langModel = new LangModel(strarr[i],imgLang[i]);
            langModelArrayList.add(langModel);
        }

        MyBaseGridAdapter myBaseGridAdapter = new MyBaseGridAdapter(this , langModelArrayList);
        gridView.setAdapter(myBaseGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strData = langModelArrayList.get(i).getStrlang();
                int img = langModelArrayList.get(i).getImglang();
                Intent j = new Intent(CustomGridView.this , GridClickLayout.class);
                j.putExtra("KEY_VALUENM" , strData);
                j.putExtra("KEY_VALUEIMG" , img);
                startActivity(j);
            }
        });
    }
}