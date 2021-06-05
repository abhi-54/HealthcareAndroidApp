package com.example.healthcare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class WaterAlarmActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_alarm);
        createNotificationChannel();

        Button menAlarmBtn =findViewById(R.id.men_alarm);
        Button cancelAlarm = findViewById(R.id.cancelAlarm);

        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(WaterAlarmActivity.this,ReminderBroadCast.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterAlarmActivity.this,0,intent,0);

        menAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterAlarmActivity.this, "Water Reminder set!", Toast.LENGTH_SHORT).show();

                long timeAtButtonClick= System.currentTimeMillis();

                //interval in seconds
                long timeInterval = 5;

                alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                        (timeInterval*1000), timeInterval*1000, pendingIntent);
                }

        });

        cancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterAlarmActivity.this, "Water Reminder Ended!", Toast.LENGTH_SHORT).show();

                if (alarmManager != null)
                {
                    alarmManager.cancel(pendingIntent);
                }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(WaterAlarmActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}