package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {
    int year,month,day;
    DatePicker datePicker;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        button=findViewById(R.id.bn);
        datePicker=findViewById(R.id.date);
        Calendar calendar=Calendar.getInstance();  //日期类是抽象类，单例设计模式
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                MainActivity.this.year=year;
                MainActivity.this.month=month;
                MainActivity.this.day=day;
                show(year,month,day);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("calendar");
                startActivity(intent);
            }
        });
    }

    private void show(int year, int month, int day) {
        String str = year+"年"+(month+1)+"月"+day+"日";
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
