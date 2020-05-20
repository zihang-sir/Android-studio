package com.example.userregist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ShowActivity extends AppCompatActivity {
    private TextView tv_name;
    private TextView tv_password;
    private ProgressBar mprogressBar1;
    private ProgressBar mprogressBar2;
    private ProgressBar mprogressBar3;
    private TextView myLife;
    private TextView mAttack;
    private TextView mSpeed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usershow);
        Intent intent=getIntent();//获取Intent对象
        String name=intent.getStringExtra("name");//获取键值
        String password=intent.getStringExtra("password");
        tv_name=findViewById(R.id.name);
        tv_password=findViewById(R.id.password);
        tv_name.setText("用户名："+name);
        tv_password.setText("密  码："+password);
        mAttack=findViewById(R.id.attack_progress);
        mSpeed=findViewById(R.id.speed_progress);
        myLife=findViewById(R.id.life_progress);
        initProgress();
    }

    private void initProgress() {
        mprogressBar1=findViewById(R.id.progressBar1);
        mprogressBar2=findViewById(R.id.progressBar2);
        mprogressBar3=findViewById(R.id.progressBar3);
        mprogressBar1.setMax(1000);
        mprogressBar2.setMax(1000);
        mprogressBar3.setMax(1000);
    }
    public void onclick(View view){

                Intent intent=new Intent(this,ShopAcitivity.class);
                startActivityForResult(intent,1);

    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            if(requestCode==1){
                if (resultCode == 1){
                    ItemInfo info=(ItemInfo) data.getSerializableExtra("equipment");
                    updateProgress(info);
                }
                }
            }
        }

    private void updateProgress(ItemInfo info) {
        int progress1=mprogressBar1.getProgress();
        int progress2=mprogressBar1.getProgress();
        int progress3=mprogressBar1.getProgress();
        mprogressBar1.setProgress(progress1+info.getLife());
        mprogressBar2.setProgress(progress2+info.getAttack());
        mprogressBar3.setProgress(progress3+info.getSpeed());
        myLife.setText(mprogressBar1.getProgress()+"");
        mAttack.setText(mprogressBar2.getProgress()+"");
        mSpeed.setText(mprogressBar3.getProgress()+"");
    }
}

