package com.example.qqpasswords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNumber;
    private EditText etPassword;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        initView();
        Map<String,String>userInfo =SPSaveQQ.getUserInfo(this);
        if(userInfo!=null){
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
        }
    }

    private void initView() {
        etNumber=findViewById(R.id.number);
        etPassword=findViewById(R.id.password);
        button=findViewById(R.id.bn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String number =etNumber.getText().toString().trim();
        String password=etPassword.getText().toString().trim();
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"请输入QQ账号",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        boolean isSaveSuccess=SPSaveQQ.saveUserInfo(this,number,password);
        if(isSaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"保存失败",Toast.LENGTH_SHORT).show();
        }
    }
}
