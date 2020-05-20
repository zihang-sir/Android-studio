package com.example.orderbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverThree extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("MyBroadcastReceiverThree","广播接收者3接收到事件");
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
