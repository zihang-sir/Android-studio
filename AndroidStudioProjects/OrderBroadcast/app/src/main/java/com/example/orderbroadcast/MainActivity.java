package com.example.orderbroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //动态注册广播对象声明为类的成员变量
    MyReceiverOne receiverOne=new MyReceiverOne();
    MyReceiverTwo receiverTwo=new MyReceiverTwo();
    MyReceiverThree receiverThree=new MyReceiverThree();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction("Intercept_Stitch");
        filter2.setPriority(1000);
        this.registerReceiver(receiverTwo, filter2);

        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("Intercept_Stitch");
        filter1.setPriority(1000);
        this.registerReceiver(receiverOne, filter1);

        IntentFilter filter3 = new IntentFilter();
        filter3.addAction("Intercept_Stitch");
        filter3.setPriority(1000);
        this.registerReceiver(receiverThree, filter3);

    }
    public void send(View view){
        Intent intent=new Intent();
        intent.setAction("Intercept_Stitch");
        sendOrderedBroadcast(intent,null,receiverThree,null,0,null,null);
    }
    protected void onDestory(){
        super.onDestroy();
        unregisterReceiver(receiverOne);
        unregisterReceiver(receiverTwo);
        unregisterReceiver(receiverThree);
    }
}
