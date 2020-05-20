package com.example.listener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        button=findViewById(R.id.bn1);
        button2=findViewById(R.id.bn2);
        button3=findViewById(R.id.bn3);
        button4=findViewById(R.id.bn4);
        textView=findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("ennn");
                AlertDialog.Builder alertDialog;
                alertDialog=new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("AlertDlalog");
                alertDialog.setMessage("你想怎么选");
                alertDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("I am studying");
                    }
                });
                alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textView.setText("I am sleeping");
                    }
                });
                alertDialog.create();
                alertDialog.show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alertone;
                alertone=new AlertDialog.Builder(MainActivity.this);
                alertone.setTitle("请选择性别");
                final String items[]={"男","女"};
                alertone.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String item=items[i];
                        textView.setText("性别："+item);
                    }
                });
                alertone.setPositiveButton("确定",null);
                alertone.show();

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder duoxuan;
                duoxuan=new AlertDialog.Builder(MainActivity.this);
                duoxuan.setTitle("请添加兴趣爱好");
                final String hobbies[]={"旅游","美食","汽车","宠物"};
                final boolean[] check={false,false,false,false};
                duoxuan.setMultiChoiceItems(hobbies, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                            if(b){
                                check[i]=true;  //检查是否被选中
                            }
                    }
                });
                duoxuan.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuffer temps=new StringBuffer();
                        for (int j=0;j<hobbies.length;j++){
                            if(check[j]){
                                String temp=hobbies[j];
                                temps.append(temp+" ");
                                Toast.makeText(MainActivity.this, temps, Toast.LENGTH_SHORT).show();
                            }
                        }
                        textView.setText(temps);
                    }
                });
                duoxuan.show();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog;
                progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("进度条对话框");
                progressDialog.setMessage("下载中，请稍后");
                //水平进度条
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
            }
        });

    }
}
