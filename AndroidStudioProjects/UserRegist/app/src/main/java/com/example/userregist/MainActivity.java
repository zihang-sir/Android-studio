package com.example.userregist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et_password;
    private Button btn_send;
    private EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        et_name=findViewById(R.id.et_name);
        et_password=findViewById(R.id.et_password);
        btn_send=findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passDate();
            }
        });
    }

    private void passDate() {
        Intent intent=new Intent(this,ShowActivity.class);//显式意图
        intent.putExtra("name",et_name.getText().toString().trim());//键值对传递数据
        intent.putExtra("password",et_password.getText().toString().trim());
        startActivity(intent);
    }
}
