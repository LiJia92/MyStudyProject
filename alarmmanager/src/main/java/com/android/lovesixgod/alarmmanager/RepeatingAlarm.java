package com.android.lovesixgod.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Jaceli on 2016-08-12.
 */
public class RepeatingAlarm extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "RepeatingAlarm onReceive", Toast.LENGTH_SHORT).show();
        Log.e("TAG", "RepeatingAlarm onReceive");
    }
}
