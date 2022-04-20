package com.loginapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyBaseGridAdapter extends BaseAdapter {
    Context context;
    ArrayList<LangModel> langModelArrayList;
    public MyBaseGridAdapter(Context context, ArrayList<LangModel> langModelArrayList) {
        this.context = context;
        this.langModelArrayList = langModelArrayList;
    }

    @Override
    public int getCount() {
        return langModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return langModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.cust_grid_view,null);
        TextView textView = view.findViewById(R.id.custmgridtext);
        CircleImageView circleImageView = view.findViewById(R.id.grid_data_img);
        LangModel langModel = langModelArrayList.get(i);
        circleImageView.setImageResource(langModelArrayList.get(i).getImglang());
        textView.setText(langModel.getStrlang());
        return view;
    }
}
