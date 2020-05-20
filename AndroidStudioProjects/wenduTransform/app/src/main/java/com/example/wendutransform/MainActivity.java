package com.example.wendutransform;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup radioGroup;
    //private RadioButton huashi;
    private TextView textView;
    private Button button;
    private EditText editText;
    private double c;
    private double f;
    private double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        editText=findViewById(R.id.edit1);
        radioGroup=findViewById(R.id.rgp);
        //huashi=findViewById(R.id.radioButton1);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView3);
        button.setOnClickListener(this);

        //设置对话框
        AlertDialog dialog;
        //绑定当前页面窗口
        dialog=new AlertDialog.Builder(this).setTitle("Dialog")
                .setMessage("是否退出")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("确定",null)
                .setNegativeButton("取消",null)
                .create();
        dialog.show();



    }
    public void onClick(View view) {
        final String str = editText.getText().toString().trim();
        if("".equals(str)){
            Toast.makeText(MainActivity.this,"请输入一个温度值",Toast.LENGTH_LONG).show();
            return ;
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radioButton1){
                    f=Double.parseDouble(str);
                    c=5.0/9.0*(f-32);
                    value=c;
                }else{
                    c=Double.parseDouble(str);
                    f=9.0/5.0*c+32;
                    value=f;
                }
            }
        });

//        float temp=Float.parseFloat(str);
//        if(huashi.isChecked()){
//            value=(float) (5.0/9.0*(temp-32));	//思考： 5/9*(temp-32)对吗？
//            str="对应摄氏温度为："+ String.format("%.1f",value);
//        }
//        else{
//            value=(float) (9.0/5.0*temp+32);
//            str="对应华氏温度为："+ String.format("%.1f",value);
//        }
//        textView.setText(str);

        if(value==c){
            textView.setText("对应摄氏温度为："+String.format("%.1f",value));
        }else{
            textView.setText("对应的华氏温度："+String.format("%.1f",value));
        }


    }

}
