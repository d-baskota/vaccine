package com.example.childvaccination;


import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.vaccine.R;

public class AlarmBroadCastReciever extends BroadcastReceiver {
    @SuppressLint("WrongConstant")
    @Override
    public void onReceive(Context context, Intent intent) {
//        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        Ringtone r = RingtoneManager.getRingtone(context, notification);
//        r.play();

        NotificationCompat.Builder notificationBuilder;
        NotificationManager nm;
        nm = (NotificationManager) context.getSystemService("notification");
        notificationBuilder = new NotificationCompat.Builder(context, "channel_id")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Reminder")
                .setContentText(intent.getStringExtra("BODY") + " Reminder")
                .setAutoCancel(true).setProgress(0, 0, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("channel_id",
                    "channel_id",
                    NotificationManager.IMPORTANCE_DEFAULT);
            nm.createNotificationChannel(channel);
        }
        nm.notify((int) System.currentTimeMillis(), notificationBuilder.build());
    }
}
