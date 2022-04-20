package com.example.test7broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkChangeReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkChangeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        boolean isWiMax = activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;
        boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        if (isConnected){
            if (isWiMax){
                Log.d(TAG,"当前手机网络类型为流量");
            }else if (isWiFi){
                Log.d(TAG,"当前手机网络类型为WiFi");
            }else {
                Log.d(TAG,"当前手机网络类型未知");
            }
        }else {
            Log.d(TAG,"网络断开连接");
        }
    }
}