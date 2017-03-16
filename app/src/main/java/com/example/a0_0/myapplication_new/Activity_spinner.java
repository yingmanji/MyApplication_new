package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity_spinner extends Activity {
    TextView tv;
    Spinner spinner;
    String[] items = {"北京市", "上海市", "广州市", "深圳市", "重庆市", "天津市", "武汉市", "西安市", "沈阳市", "长沙市", "珠海市"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        tv = (TextView) findViewById(R.id.tv);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(arrayAdapter);
    }
}