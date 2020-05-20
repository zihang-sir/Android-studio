package com.example.mydirectory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //对象声明
    MyHelper myHelper;
    private EditText mEtName;
    private EditText mEtPhone;
    private TextView mTvShow;
    private Button mBtnAdd;
    private Button mBtnQuery;
    private Button mBtnUpdate;
    private Button mBtnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tongxunlu);
        myHelper=new MyHelper(this);
        init();

    }
    //初始化
    private void init() {
        mBtnAdd=findViewById(R.id.btn_add);
        mBtnDelete=findViewById(R.id.btn_delete);
        mBtnQuery=findViewById(R.id.btn_query);
        mBtnUpdate=findViewById(R.id.btn_update);
        mEtName=findViewById(R.id.et_name);
        mEtPhone=findViewById(R.id.et_phone);
        mTvShow=findViewById(R.id.tv_show);
        mBtnAdd.setOnClickListener(this);
        mBtnQuery.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name;
        String phone;
        SQLiteDatabase db;
        ContentValues values;
        switch (v.getId()){
            case R.id.btn_add:
                name=mEtName.getText().toString();
                phone=mEtPhone.getText().toString();
                db=myHelper.getReadableDatabase();
                values=new ContentValues();
                values.put("name",name);
                values.put("phone",phone);
                db.insert("information",null,values);
                Toast.makeText(this,"信息已添加",Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_query:
                db=myHelper.getReadableDatabase();
                Cursor cursor=db.query("information",null,null,null,null,null,null);
                if(cursor.getCount()==0){
                    mTvShow.setText("");
                    Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
                }else{
                    cursor.moveToFirst();
                    mTvShow.setText("Name:"+cursor.getString(1)+";Tel:"+cursor.getString(2));
                }
                while (cursor.moveToNext()){
                    mTvShow.append("\n"+"Name:"+cursor.getString(1)+";Tel:"+cursor.getString(2));
                }
                cursor.close();
                db.close();
                break;
            case R.id.btn_update:
                db=myHelper.getWritableDatabase();
                values=new ContentValues();
                values.put("phone",phone=mEtPhone.getText().toString());
                db.update("information",values,"name=?",new String[]{mEtName.getText().toString()});
                Toast.makeText(this,"信息已修改",Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_delete:
                db=myHelper.getWritableDatabase();
                db.delete("information",null,null);
                Toast.makeText(this,"信息已删除",Toast.LENGTH_SHORT).show();
                mTvShow.setText("");
                db.close();
                break;
        }
    }
    class MyHelper extends SQLiteOpenHelper {
        public MyHelper(@Nullable Context context) {
            super(context, "itcast.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20),phone VARCHAR(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
