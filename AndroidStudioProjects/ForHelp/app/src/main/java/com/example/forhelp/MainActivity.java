package com.example.forhelp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendhelp);
    }
    //8.0为了管理系统和节约电量特别针对广播和服务发送intent的方式启动做出的改变
    // ，也就是说广播和服务不能随意收intent了，要对广播和服务更精确的指向，
    // 所以在创建intent的时候，我们需要指定我们的广播和服务的包名加类名，为的就是精确。
    public void send(View view){
        Intent intent=new Intent("com.hisense.test.broadcast");
        intent.setComponent(new ComponentName("com.example.forhelp","com.example.forhelp.HelpReceiver"));
        intent.setAction("Help_Stitch");//定义广播类型，“”中内容与广播接收者一致
        sendBroadcast(intent);
    }
}
