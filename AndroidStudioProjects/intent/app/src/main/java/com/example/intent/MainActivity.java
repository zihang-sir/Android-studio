package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_internet;
    private Button button_number;
    private Button button_call;
    private Button button_message;
    private Button button_send;
    private Button button_music;
    private Button button_uninstall;
    private Button button_install;
    private Button button_action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        button_internet=findViewById(R.id.internet);
        button_number=findViewById(R.id.btn_number);
        button_call=findViewById(R.id.btn_call);
        button_message=findViewById(R.id.btn_message);
        button_send=findViewById(R.id.send_message);
        button_music=findViewById(R.id.btn_music);
        button_uninstall=findViewById(R.id.uninstall);
        button_install=findViewById(R.id.install);
        button_action=findViewById(R.id.action_install);
        button_internet.setOnClickListener(this);
        button_number.setOnClickListener(this);
        button_call.setOnClickListener(this);
        button_message.setOnClickListener(this);
        button_music.setOnClickListener(this);
        button_uninstall.setOnClickListener(this);
        button_install.setOnClickListener(this);
        button_send.setOnClickListener(this);
        button_action.setOnClickListener(this);

    }
//需要我们在运行虚拟机模拟时，在设置中手动开启权限，开启之后就不会再报错了。
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.internet:
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);//方法：android.content.Intent.Intent(String action)
                Uri data = Uri.parse("http://www.baidu.com");
                intent.setData(data);
                startActivity(intent);
                break;
            case R.id.btn_number:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"));
                startActivity(intent2);
                break;
            case R.id.btn_call:
                Intent intent3 = new Intent(Intent.ACTION_CALL);
                intent3.setData(Uri.parse("tel:10086"));
                startActivity(intent3);
                break;
            case R.id.btn_message:
                Intent intent4 = new Intent(Intent.ACTION_VIEW);
                intent4.setType("vnd.android-dir/mms-sms");
                //intent4.putExtra("sms_body", "具体短信内容"); //"sms_body"为固定内容
                startActivity(intent4);
                break;
            case R.id.send_message:
                Intent intent5 = new Intent(Intent.ACTION_SENDTO);
                intent5.setData(Uri.parse("smsto:18780260012"));
                intent5.putExtra("sms_body", "具体短信内容"); //"sms_body"为固定内容
                startActivity(intent5);
                break;
            case R.id.btn_music:
                Intent intent6 = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("file:///storage/sdcard0/平凡之路.mp3"); ////路径也可以写成："/storage/sdcard0/平凡之路.mp3"
                intent6.setDataAndType(uri, "audio/mp3"); //方法：Intent android.content.Intent.setDataAndType(Uri data, String type)
                startActivity(intent6);
                break;
            case R.id.uninstall:
                Intent intent7 = new Intent(Intent.ACTION_DELETE);
                Uri data7 = Uri.parse("package:com.example.weather");
                intent7.setData(data7);
                startActivity(intent7);
                break;
            case R.id.install:
                Intent intent8 = new Intent(Intent.ACTION_VIEW);
                Uri data8 = Uri.fromFile(new File("/storage/sdcard0/AndroidTest/smyh006_Intent01.apk"));    //路径不能写成："file:///storage/sdcard0/···"
                intent8.setDataAndType(data8, "application/vnd.android.package-archive");  //Type的字符串为固定内容
                startActivity(intent8);
                break;
            case R.id.action_install:
                Intent intent9 = new Intent(Intent.ACTION_PACKAGE_ADDED);
                Uri data9 = Uri.fromFile(new File("/storage/sdcard0/AndroidTest/smyh006_Intent01.apk"));    //路径不能写成："file:///storage/sdcard0/···"
                intent9.setData(data9);
                startActivity(intent9);
                break;
        }

    }
}
