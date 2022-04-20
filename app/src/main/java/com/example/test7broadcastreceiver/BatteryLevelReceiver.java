package com.example.test7broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class BatteryLevelReceiver extends BroadcastReceiver {

    private int battery;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //判断当前电池电量
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level * 100 / (float)scale;
        Log.i("BatteryLevelReceiver","电量："+batteryPct);
        if(batteryPct<=20){
            Log.d("BatteryLevelReceiver","电量较低" );
        }
        if(batteryPct>20){
            Log.d("BatteryLevelReceiver","电量充足" );
        }
    }
}