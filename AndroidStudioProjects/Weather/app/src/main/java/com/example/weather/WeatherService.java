package com.example.weather;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    public static List<WeatherInfo>getInfoFromXML (InputStream is)throws Exception{
        XmlPullParser parser= Xml.newPullParser();
        parser.setInput(is,"utf-8");
        List<WeatherInfo>weatherInfos=null;
        WeatherInfo weatherInfo=null;
        int type =parser.getEventType();
        while (type!=XmlPullParser.END_DOCUMENT){
            switch (type){
                //一个节点开始标签
                case XmlPullParser.START_TAG:
                    //解析到全局开始的标签infos根节点，“”中名称与xml文件中相同
                    if("infos".equals(parser.getName())){
                        weatherInfos=new ArrayList<WeatherInfo>();
                    }else if("city".equals(parser.getName())){
                        weatherInfo=new WeatherInfo();
                        String idStr=parser.getAttributeValue(0);
                        weatherInfo.setId(idStr);
                    }else if("temp".equals(parser.getName())){
                        String temp=parser.nextText();
                        weatherInfo.setTemp(temp);
                    }else if("weather".equals(parser.getName())){
                        String weather =parser.nextText();
                        weatherInfo.setWeather(weather);
                    }else if("name".equals(parser.getName())){
                        String name=parser.nextText();
                        weatherInfo.setName(name);
                    }else if("pm".equals(parser.getName())){
                        String pm=parser.nextText();
                        weatherInfo.setPm(pm);
                    }else if("wind".equals(parser.getName())){
                        String wind=parser.nextText();
                        weatherInfo.setWind(wind);
                    }
                    break;
                    //一个节点结束标签
                case XmlPullParser.END_TAG:
                    if("city".equals(parser.getName())){
                        weatherInfos.add(weatherInfo);
                        weatherInfo=null;
                    }
                    break;
            }
            type=parser.next();
        }
        return weatherInfos;
    }
}
