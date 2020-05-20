package com.example.listener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MyDialog extends Dialog {
    private String dialogName;
    private TextView tvMsg;
    private Button btnOk;
    private Button btnNo;
    public MyDialog(Context context,String dialogName) {
        super(context);
        this.dialogName=dialogName;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_dialog);
        tvMsg=findViewById(R.id.tv_msg);
        btnOk=findViewById(R.id.ok);
        btnNo=findViewById(R.id.no);
        tvMsg.setText(dialogName);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
