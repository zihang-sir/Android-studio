package com.example.userregist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShopAcitivity extends AppCompatActivity implements View.OnClickListener {
    private ItemInfo itemInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);
        itemInfo=new ItemInfo("金剑",100,50,30);
        findViewById(R.id.r1).setOnClickListener(this);
        TextView mylife=findViewById(R.id.tv_life);
        TextView myattack=findViewById(R.id.tv_attack);
        TextView myspeed=findViewById(R.id.tv_speed);
        TextView myname=findViewById(R.id.tv_name);
        mylife.setText("生命值+"+itemInfo.getLife());
        myname.setText(itemInfo.getName()+"");
        myattack.setText("攻击力+"+itemInfo.getAttack());
        myspeed.setText("敏捷度+"+itemInfo.getSpeed());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.r1:
                Intent intent=new Intent();
                intent.putExtra("equipment",itemInfo);
                setResult(1,intent);
                finish();
                break;
        }
    }
}
