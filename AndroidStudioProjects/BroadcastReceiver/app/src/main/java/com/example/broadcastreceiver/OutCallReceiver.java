package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class OutCallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        String outcallnumber =getResultData();
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        String number =sp.getString("number","");
        if(outcallnumber.equals(number)){
            setResultData(null);
        }
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}
