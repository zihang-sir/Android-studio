package com.example.forhelp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class HelpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.i("Help","自定义的广播接收者，收到求救");
        Log.i("Help",intent.getAction());
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
