package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewLayout extends AppCompatActivity {

    String strarr[] = {"Android","Php","Java","iOS","C","C++","Python"};
    int imgLang[] = {R.mipmap.ic_launcher_round, R.drawable.ic_php, R.drawable.ic_java, R.drawable.ic_ios , R.drawable.ic_c,R.drawable.ic_cc , R.drawable.ic_python};
    ListView listView;
    ArrayList<LangModel> langModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view_layout);
        listView = findViewById(R.id.custlistview);

        langModelArrayList = new ArrayList<LangModel>();
        for(int i=0 ; i< strarr.length ; i++) {
            LangModel langModel = new LangModel(strarr[i], imgLang[i]);
            langModelArrayList.add(langModel);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this,langModelArrayList);
        listView.setAdapter(myBaseAdapter);
    }
}