package com.example.test7broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class PowerConnectionReceiver extends BroadcastReceiver {

    private static final String TAG = "PowerConnectionReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//得到电池当前的状态（共有5种，包括unkonwn、charging、discharging、not charging、full）
        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
//是否处于充电状态
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;
//充电方式（共有两种，分别是通过AC充电和通过USB端口进行充电）
        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        Log.i("BatteryLevelReceiver", "isCharging:" + isCharging + "；"
                + "usbCharge:" + usbCharge + "；" + "acCharge:" + acCharge);
        if(isCharging){
            if(usbCharge){
                Log.d(TAG,"手机正在使用usb接口充电。");
            }
            else if(acCharge){
                Log.d(TAG,"手机正在使用交流充电器充电。");
            }
            else {
                Log.d(TAG,"手机正在使用未知方式充电。");
            }
        }
    }
}