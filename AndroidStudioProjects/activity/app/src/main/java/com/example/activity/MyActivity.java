package com.example.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private static String tag="myTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        button=findViewById(R.id.bn);
        button.setOnClickListener(this);
        Log.i(tag,"onCreate is running");
    }
    protected void onStart() {
        super.onStart();
        Log.i(tag,"onStart is running");
    }
    protected void onResume() {
        super.onResume();
        Log.i(tag,"onResume is running");
    }
    protected void onPause() {
        super.onPause();
        Log.i(tag,"onPause is running");
    }
    protected void onStop() {
        super.onStop();
        Log.i(tag,"onStop is running");
    }
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"onDestroy is running");
    }
    protected void onRestart() {
        super.onRestart();
        Log.i(tag,"onRestart is running");
    }

    @Override
    public void onClick(View view) {
//        AlertDialog.Builder alert;
//        alert=new AlertDialog.Builder(MyActivity.this);
//        alert.setTitle("弹动的小球");
//        alert.setPositiveButton("ok",null);
//        alert.setNegativeButton("no",null);
//        alert.create();
//        alert.show();
//        Intent intent=new Intent(this,MainActivity.class);
//        startActivity(intent);
        Intent intent=new Intent();
        intent.setAction("this is my order");
        intent.putExtra("mymessage",button.getText());
        startActivity(intent);
    }
}
