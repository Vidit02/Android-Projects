package com.loginapp;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class BrowserGalleryOpen extends AppCompatActivity {
    Button gallery, browser, camera, drawab, seek, viewval, alertbtn, custalert ,custtoast ,custemail, datepick,timepick, selectbtn;
    ImageView imgview;
    String course;
    Spinner spinner;
    TextView textdate,timeshow;
    int date , year;
    private int month;
    private int minute;
    private int hour;
    String strarr[] = {"Select Any One Course","Android","Php","Rust","Clojure","Flutter","Spring"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_gallery_open);

        textdate = findViewById(R.id.dateshow);
        timeshow = findViewById(R.id.timeshow);
        browser = findViewById(R.id.browsebtn);
        gallery = findViewById(R.id.gallerybtn);
        camera = findViewById(R.id.camerabtn);
        drawab = findViewById(R.id.drawablebtn);
        imgview = findViewById(R.id.img_logoop);
        seek = findViewById(R.id.seekbarbtn);
        viewval = findViewById(R.id.view_btn);
        alertbtn = findViewById(R.id.alertbtn);
        custalert = findViewById(R.id.customalertbtn);
        custtoast = findViewById(R.id.customtoast);
        custemail = findViewById(R.id.custemail);
        datepick = findViewById(R.id.datepick);
        timepick = findViewById(R.id.timepick);
        spinner = findViewById(R.id.spinnerbtn);
        selectbtn = findViewById(R.id.selectcr);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strarr){
            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView tvcolor = (TextView) super.getDropDownView(position,convertView,parent);

                if(position == 0){
                    tvcolor.setTextColor(Color.GRAY);
                } else{
                    tvcolor.setTextColor(Color.GREEN);
                }

                return tvcolor;
            }
        };
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    String strdata = parent.getItemAtPosition(position).toString();
                    textdate.setText("Course : " + strdata);
                    course = strdata;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        selectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BrowserGalleryOpen.this , HomeActivity.class);
                i.putExtra("KEY_COURSE",course);
                startActivity(i);
            }
        });


        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        minute = calendar.get(Calendar.MINUTE);
        hour = calendar.get(Calendar.HOUR);

        timepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(BrowserGalleryOpen.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                              timeshow.setText(hourOfDay + ":" + minute);
                            }
                        },hour,minute,true );
                timePickerDialog.show();
            }
        });

        datepick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(BrowserGalleryOpen.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                textdate.setText(dayOfMonth + "/" + (month+1) + "/" + year);
                            }
                        },year,month,date);
                datePickerDialog.show();
            }
        });

        custemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.alert_activity,null);
                Button submitbtn = myview.findViewById(R.id.submit_btn);
                EditText Emailid   = myview.findViewById(R.id.edit_emailid);
                AlertDialog.Builder builder = new AlertDialog.Builder(BrowserGalleryOpen.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(myview);
                alertDialog.show();
                submitbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        String email = Emailid.getText().toString();
                        View myToast = layoutInflater.inflate(R.layout.custom_toast,null);
                        Toast toast = new Toast(BrowserGalleryOpen.this);
                        Toast to = new Toast(getApplicationContext());
                        TextView tv = (TextView) myToast.findViewById(R.id.texttoast);
                        toast.setDuration(Toast.LENGTH_LONG);
                        tv.setText(email);
                        toast.setView(myToast);
                        toast.show();

//                        Toast.makeText(BrowserGalleryOpen.this, "Email id :" + email, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        custtoast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myToast = layoutInflater.inflate(R.layout.custom_toast,null);
                Toast toast = new Toast(BrowserGalleryOpen.this);
                toast.setView(myToast);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
        custalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = getLayoutInflater();
                View myview = layoutInflater.inflate(R.layout.alert_activity,null);
                Button submitbtn = myview.findViewById(R.id.submit_btn);
                EditText Emailid   = myview.findViewById(R.id.edit_emailid);

                AlertDialog.Builder builder = new AlertDialog.Builder(BrowserGalleryOpen.this);
                AlertDialog alertDialog = builder.create();
                alertDialog.setView(myview);
                alertDialog.show();
                submitbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(alertDialog.isShowing()){
                            alertDialog.dismiss();
                        }
                        String email = Emailid.getText().toString();
                        Toast.makeText(BrowserGalleryOpen.this, "Email id :" + email, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_PICK);
                i.setType("image/*");
                startActivityForResult(i, 11);
            }
        });
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http:www.google.com/"));
                startActivity(i);
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, 12);
            }
        });
        drawab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview.setImageResource(R.drawable.cam);
            }
        });
        seek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BrowserGalleryOpen.this, SeekBarRatingBar.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 11) {
            Uri uri = data.getData();
            imgview.setImageURI(uri);
        }
        if (requestCode == 12) {
            Bitmap bit = (Bitmap) data.getExtras().get("data");
            imgview.setImageBitmap(bit);
        }
    }

    public void alertAction(View view) {

        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setIcon(R.drawable.ic_baseline_person_24);
        build.setTitle(getResources().getString(R.string.app_name));
        build.setMessage("Are you sure you want to exit?");
        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BrowserGalleryOpen.this, "Yes is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        build.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BrowserGalleryOpen.this, "No is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        build.setNeutralButton("Finish", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        build.show();
    } // For alert box

    @Override
    public void onBackPressed() {
        AlertDialog.Builder build = new AlertDialog.Builder(this);
        build.setIcon(R.drawable.ic_baseline_person_24);
        build.setTitle(getResources().getString(R.string.app_name));
        build.setMessage("Are you sure you want to exit?");
        build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        build.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(BrowserGalleryOpen.this, "No is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        build.show();
    }
}