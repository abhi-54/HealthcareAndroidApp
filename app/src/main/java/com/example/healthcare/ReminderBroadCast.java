package com.example.healthcare;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.healthcare.R;

public class ReminderBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context, "notify")
                .setSmallIcon(R.drawable.healthcare_logo)
                .setContentTitle("Water Alarm")
                .setContentText("Hey, this is reminder of water drink")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager =NotificationManagerCompat.from(context);

        notificationManager.notify(200,builder.build());
    }
}
