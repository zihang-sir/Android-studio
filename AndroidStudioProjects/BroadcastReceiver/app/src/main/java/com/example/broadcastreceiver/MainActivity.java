package com.example.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_number;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interceptcall);
        et_number=findViewById(R.id.et_ipnumber);
        sp=getSharedPreferences("config",MODE_PRIVATE);
        //动态权限申请
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS},100);
    }
    public void click(View view){
        String number=et_number.getText().toString().trim();
        //保存用户输入的拦截号码
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("number",number);
        editor.commit();
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
    }
}
