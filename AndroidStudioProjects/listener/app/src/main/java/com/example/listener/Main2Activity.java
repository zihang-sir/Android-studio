package com.example.listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);
        MyDialog myDialog=new MyDialog(this,"我是自定义的Dialog");
        myDialog.show();
    }
}
