package com.example.myapplicationmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView mlistView;
    //需要适配的数据
    private String[]names={"京东","QQ","QQ斗地主","新浪","天猫","UC","微信"};
    private int[]icons={R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        mlistView=findViewById(R.id.lv);
        MyBaseAdapter mAdapter=new  MyBaseAdapter();
        mlistView.setAdapter(mAdapter);
    }
    class  MyBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            //返回条目总数
            return names.length;
        }
        //得到Item代表的对象
        @Override
        public Object getItem(int position) {
            return names[position];
        }
        //得到Item的id
        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            View view=View.inflate(MainActivity.this,R.layout.list_item,null);
            TextView mTextView=view.findViewById(R.id.item_tv);
            mTextView.setText(names[position]);
            ImageView imageView=view.findViewById(R.id.item_image);
            imageView.setBackgroundResource(icons[position]);
            return view;
        }
    }
}
