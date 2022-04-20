package com.example.test7broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private PowerConnectionReceiver powerConnectionReceiver;
    private BatteryLevelReceiver batteryLevelReceiver;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //监听充电类型和电量变化
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        powerConnectionReceiver = new PowerConnectionReceiver();
        this.registerReceiver(powerConnectionReceiver,ifilter);

        batteryLevelReceiver = new BatteryLevelReceiver();
        this.registerReceiver(batteryLevelReceiver,ifilter);

        //监听网络类型和变化
        IntentFilter ifilter1 = new IntentFilter();
        ifilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        this.registerReceiver(networkChangeReceiver,ifilter1);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销接收器
        unregisterReceiver(powerConnectionReceiver);
        unregisterReceiver(batteryLevelReceiver);
        unregisterReceiver(networkChangeReceiver);
    }
}