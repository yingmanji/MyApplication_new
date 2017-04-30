package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.a0_0.myapplication_new.model.NetWorkTask;

public class Activity_URL2 extends Activity {
    private TextView tv_data;
    private ProgressBar pb_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__url2);
        tv_data=(TextView) findViewById(R.id.tv_data);
        pb_load=(ProgressBar)findViewById(R.id.pb_load);
    }
    public void getNetData(View view)
    {
        //String url="https://www.taobao.com";
        String url="http://www.weather.com.cn/data/sk/101110101.html";
        new NetWorkTask(tv_data,pb_load).execute(url);
    }
}
