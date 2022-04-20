package com.firebasedatabaseappproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ListView listView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ArrayList<PeopleModel> peopleModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView = findViewById(R.id.listvw);
        peopleModels = new ArrayList<PeopleModel>();
        firebaseDatabase = FirebaseDatabase.getInstance("https://fir-databaseappproject-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    PeopleModel peopleModel = dataSnapshot1.getValue(PeopleModel.class);
                    peopleModels.add(peopleModel);
                }
                ArrayAdapter<PeopleModel> arrayAdapter = new ArrayAdapter<PeopleModel>(DisplayActivity.this, android.R.layout.simple_list_item_1,peopleModels){
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        TextView tvdata = (TextView) super.getView(position,convertView,parent);
                        tvdata.setText(peopleModels.get(position).getFirstnm()+" "+peopleModels.get(position).getLastnm());
                        return tvdata;
                    }
                };
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(DisplayActivity.this,UpdateActivity.class);
                i.putExtra("KEY_FNAME",peopleModels.get(position).getFirstnm());
                i.putExtra("KEY_PID",peopleModels.get(position).getUserId());
                i.putExtra("KEY_LNAME",peopleModels.get(position).getLastnm());
                startActivity(i);
                finish();
            }
        });
    }
}