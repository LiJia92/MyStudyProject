package com.android.lovesixgod.alarmmanager;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Jaceli on 2016-08-12.
 */
public class OneShotAlarm extends BroadcastReceiver {

    private final static int NOTIFICATION_ID = 1001;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.mia_logo_notification)
                .setContentTitle("注意，直播还在继续")
                .setContentText("Mia正在直播，摄像头还在工作中。如需关闭直播，请点击直播页面右上角的关闭按钮。");
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(NOTIFICATION_ID, mBuilder.build());
        Toast.makeText(context, "OneShotAlarm onReceive", Toast.LENGTH_SHORT).show();
        Log.e("TAG", "OneShotAlarm onReceive");
    }
}
