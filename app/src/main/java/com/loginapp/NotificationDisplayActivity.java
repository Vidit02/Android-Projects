package com.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationDisplayActivity extends AppCompatActivity {
    Button notificationDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_display);
        notificationDisplay = findViewById(R.id.sendnotification);
        notificationDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    NotificationChannel notificationChannel = new NotificationChannel("com.loginapp",getString(R.string.app_name),NotificationManager.IMPORTANCE_DEFAULT);

                    Intent i = new Intent(NotificationDisplayActivity.this, CustomListViewLayout.class);
                    PendingIntent pendingIntent = PendingIntent.getActivity(NotificationDisplayActivity.this, 1, i, PendingIntent.FLAG_IMMUTABLE);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationDisplayActivity.this);
                    builder.setSmallIcon(R.drawable.ic_house);
                    builder.setContentTitle("Login App");
                    builder.setContentText("No Lecture Today");
                    builder.setContentIntent(pendingIntent);
                    builder.setChannelId("com.loginapp");
                    builder.setAutoCancel(true);

                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.notify(1, builder.build());
                }
            }
        });
    }
}