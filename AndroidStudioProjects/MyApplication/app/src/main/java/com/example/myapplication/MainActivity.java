package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{//直接实现接口
    //创建内部类   内部类实现监听接口
//    class MyListener implements View.OnClickListener{
//
//        @Override
//        public void onClick(View view) {
//            button2.setText("yes");
//        }
//    }


    private Button button1;
    private Button button2;
    private TextView textView1;
    private EditText editText1;
    private int num;
    private static int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        //实现Java与xml绑定，初始化控件
        button1=(Button)findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        textView1=findViewById(R.id.textView1);
        editText1=findViewById(R.id.editText1);

        //调用监听器,main实现了接口，this代表OnClickListener的引用
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

//        MyListener myListener=new MyListener();
//        button2.setOnClickListener(myListener);

        Random r=new Random();
        num=r.nextInt(100);
    }

    public void clickButton1(View v){
        //日志输出
       // Log.i("tag","clickButton1");

        //类型转换
        String temp =editText1.getText().toString().trim();
        if(!("".equals(temp))){
            n++;
            //包类型转换
            int value=Integer.parseInt(temp);
            if(num>value)
                textView1.setText("猜小了");
            else if(num<value){
                textView1.setText("猜大了");
            }else{
                textView1.setText("答对了\n猜了"+n+"次\n");
            }
        }

    }

    @Override
    //重写OnClickListener接口的OnClick方法
    public void onClick(View view) {
        //view形参判断是哪一个事件发生
        switch (view.getId()){
            case R.id.button1:
                button1.setText("button1被点击");
                break;
            case R.id.button2:
                button2.setText("button2被点击");
                break;
        }
    }
}
