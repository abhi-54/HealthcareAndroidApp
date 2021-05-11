package com.example.healthcare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class WaterAlarmWomenActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_alarm_women);
        createNotificationChannel();

        Button womenAlarmBtn =findViewById(R.id.women_alarm);

        womenAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterAlarmWomenActivity.this, "Water Reminder set!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(WaterAlarmWomenActivity.this,ReminderBroadCast.class);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(WaterAlarmWomenActivity.this,0,intent,0);

                AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick= System.currentTimeMillis();

                long tenSecondsInMillis=1000*10;

                alarmManager.set(AlarmManager.RTC_WAKEUP,timeAtButtonClick+tenSecondsInMillis,pendingIntent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "ReminderChannel";
            String description="Channel for Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notify",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }
}