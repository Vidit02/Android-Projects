package com.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private TextView tv_context;
    Button tvbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tv_context = (TextView) findViewById(R.id.tv_contextmenu);
        registerForContextMenu(tv_context);
        tvbtn = findViewById(R.id.btn_pop);
        tvbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this,tvbtn);
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.item_menu , popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.add_pic:
                                Toast.makeText(MenuActivity.this, "Add Photo", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.edit_pic:
                                Toast.makeText(MenuActivity.this, "Edit Photo", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.delete_pic:
                                Toast.makeText(MenuActivity.this, "Delete Photo", Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_pic:
                Toast.makeText(MenuActivity.this, "Add Photo", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.edit_pic:
                Toast.makeText(MenuActivity.this, "Edit Photo", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.delete_pic:
                Toast.makeText(MenuActivity.this, "Delete Photo", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu , menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_pic:
                Toast.makeText(MenuActivity.this, "Add Photo", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.edit_pic:
                Toast.makeText(MenuActivity.this, "Edit Photo", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.delete_pic:
                Toast.makeText(MenuActivity.this, "Delete Photo", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }
}