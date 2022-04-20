package com.loginapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment1Blank extends Fragment {
    ListView listView;
    String strarr[] = {"Android","Php","Rust","Clojure","Flutter","Spring"};
    int imgLang[] = {R.mipmap.ic_launcher_round, R.drawable.ic_php, R.drawable.ic_java, R.drawable.ic_ios , R.drawable.ic_c,R.drawable.ic_cc , R.drawable.ic_python};
    ArrayList<LangModel> langModelArrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1,container,false);
        listView = view.findViewById(R.id.listview_frag);
        langModelArrayList = new ArrayList<LangModel>();
        for(int i=0 ; i< strarr.length ; i++) {
            LangModel langModel = new LangModel(strarr[i], imgLang[i]);
            langModelArrayList.add(langModel);
        }

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(getContext(),langModelArrayList);
        listView.setAdapter(myBaseAdapter);
        return view ;

    }
}