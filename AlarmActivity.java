package com.moarhp.chronos2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


import java.util.Calendar;

/**
 * Created by Ryan and Dang on 5/1/2015.
 */
public class AlarmActivity extends Activity {

    private static final String TAG = "debugger";

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker timePicker;
    private static AlarmActivity alarmActivity;
    private TextView textView;
    private ToggleButton toggleButton;

    public static AlarmActivity instance() {

        return alarmActivity;
    }

    @Override
    public void onStart() {

        super.onStart();
        alarmActivity = this;
        AlarmActivity alarmActivity = new AlarmActivity();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        // Switch power = (Switch) findViewById(R.id.power);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggle1);
        Log.v(TAG, "Reached OnCreate");


        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Log.d(TAG, "Alarm On");
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE, timePicker.getCurrentMinute());
                    Intent myIntent = new Intent(AlarmActivity.this, AlarmReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0, myIntent, 0);
                    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
                    Log.v(TAG, "Reached Switch");



            }

        });
        }

    }














