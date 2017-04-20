package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a0_0.myapplication_new.model.NetWorkTask;

public class Activity_URL2 extends Activity {
    private TextView tv_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__url2);
        tv_data=(TextView) findViewById(R.id.tv_data);
    }
    public void getNetData(View view)
    {
        String url="https://www.baidu.com";
        new NetWorkTask(tv_data).execute(url);
    }
}
