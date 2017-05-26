package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_alert extends Activity {
    private EditText et_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        et_name=(EditText)findViewById(R.id.et_name);
    }
    public void check(View view)
    {
        if(et_name.getText().toString().trim()==null||et_name.getText().toString().trim().equals(""))
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(this);
            dialog.setIcon(R.mipmap.ic_launcher)
                    .setTitle("错误信息显示")
                    .setMessage("用户名不能为空")
                    .setCancelable(false)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Activity_alert.this, "确定", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Activity_alert.this, "取消", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNeutralButton("是", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Activity_alert.this, "是", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        }
    }
}
