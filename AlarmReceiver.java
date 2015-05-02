package com.moarhp.chronos2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by Ryan and Dang on 5/1/2015.
 */
public class AlarmReceiver extends WakefulBroadcastReceiver {


    @Override
    public void onReceive(final Context context, Intent intent) {
        final MediaPlayer player1 = MediaPlayer.create(context, R.raw.copy);
        player1.start();
        Log.v("Oh", "no");
    }
}
