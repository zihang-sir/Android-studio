package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);

        radioGroup=findViewById(R.id.rgp);
        textView=findViewById(R.id.textView);
        radioGroup.setOnCheckedChangeListener(
                //匿名内部类
                new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if(i==R.id.rbtn1){
                            textView.setText("性别：男");
                        }else{
                            textView.setText("性别：女");
                        }

                    }
                });
    }
}
