package com.example.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bn1;
    private Button bn2;
    private EditText editText1;
    private EditText editText2;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        bn1=findViewById(R.id.bn1);
        bn2=findViewById(R.id.bn2);
        editText1=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        textView=findViewById(R.id.text3);
        bn1.setOnClickListener(this);
        bn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String temp1=editText1.getText().toString();
        String temp2=editText2.getText().toString();
        double value=Double.parseDouble(temp1);
        int year=Integer.parseInt(temp2);
        double money;
        double porit;
        switch (year){
            case 1:
                porit=0.0225;
                break;
            case 2:
                porit=0.027;
                break;
            case 3:
                porit=0.0324;
                break;
            case 4:
                porit=0.0324;
                break;
            case 5:
                porit=0.036;
                break;
            default:porit=0.036;

        }

        money=value*Math.pow((1+porit),year);
        switch (view.getId()){
            case R.id.bn1:
                textView.setText("本金加利息：\n"+String.format("%.3f",money));
                break;
            case R.id.bn2:
                textView.setText("");
                editText1.setText("");
                editText2.setText("");
                break;
        }
    }
}
