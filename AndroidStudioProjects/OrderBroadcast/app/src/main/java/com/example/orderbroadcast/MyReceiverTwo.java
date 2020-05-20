package com.example.orderbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverTwo extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("MyBroadcastReceiverTwo","广播接收者2接收到事件");
        abortBroadcast();//拦截有序广播
        Log.i("MyBroadcastReceiverTwo","广播被2终结");
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
