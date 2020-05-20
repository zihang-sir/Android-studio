package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvCity;
    private TextView tvWeather;
    private TextView tvTemp;
    private TextView tvWind;
    private TextView tvPm;
    private ImageView tvIcon;
    private Map<String,String> map;
    private List<Map<String,String>> list;
    private String temp,weather,name,pm,wind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout1);
        initView();
        try {
            InputStream is=this.getResources().openRawResource(R.raw.weather1);
            List<WeatherInfo> weatherInfos=WeatherService.getInfoFromXML(is);
            list = new ArrayList<Map<String,String>>();
            for (WeatherInfo info:weatherInfos){
                map =new HashMap<String, String>();
                map.put("temp",info.getTemp());
                map.put("weather",info.getWeather());
                map.put("name",info.getName());
                map.put("pm",info.getPm());
                map.put("wind",info.getWind());
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"解析天气信息失败",Toast.LENGTH_SHORT).show();
        }
        getMap(1,R.drawable.ic_launcher_foreground);
    }

    private void getMap(int number, int iconNumber) {
        Map<String,String> cityMap=list.get(number);
        temp=cityMap.get("temp");
        weather=cityMap.get("weather");
        name=cityMap.get("name");
        pm=cityMap.get("pm");
        wind=cityMap.get("wind");
        tvCity.setText(name);
        tvWind.setText("风力："+wind);
        tvWeather.setText(weather);
        tvTemp.setText(""+temp);
        tvIcon.setImageResource(iconNumber);
        tvPm.setText("pm:"+pm);

    }

    private void initView() {
        tvCity=findViewById(R.id.city);
        tvTemp=findViewById(R.id.temp);
        tvPm=findViewById(R.id.pm);
        tvWeather=findViewById(R.id.weather);
        tvWind=findViewById(R.id.wind);
        tvIcon=findViewById(R.id.imageView);
        findViewById(R.id.bj).setOnClickListener(this);
        findViewById(R.id.sh).setOnClickListener(this);
        findViewById(R.id.gz).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sh:
                getMap(0,R.drawable.ic_launcher_foreground);
                break;
            case R.id.bj:
                getMap(1,R.drawable.ic_launcher_foreground);
                break;
            case R.id.gz:
                getMap(2,R.drawable.ic_launcher_foreground);
                break;
        }
    }
}
