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
        Button cancelAlarmW = findViewById(R.id.cancelAlarmW);

        Intent intentW = new Intent(WaterAlarmWomenActivity.this,ReminderBroadCast.class);
        PendingIntent pendingIntentW = PendingIntent.getBroadcast(WaterAlarmWomenActivity.this,0,intentW,0);

        AlarmManager alarmManagerW = (AlarmManager) getSystemService(ALARM_SERVICE);

        womenAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterAlarmWomenActivity.this, "Water Reminder set!", Toast.LENGTH_SHORT).show();

                long timeAtButtonClick= System.currentTimeMillis();

                long interval = 5;

                alarmManagerW.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() +
                        (interval*1000), interval*1000, pendingIntentW);
            }
        });

        cancelAlarmW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterAlarmWomenActivity.this, "Water Reminder Ended!", Toast.LENGTH_SHORT).show();

                if (alarmManagerW != null)
                {
                    alarmManagerW.cancel(pendingIntentW);
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
        Intent i = new Intent(WaterAlarmWomenActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
}