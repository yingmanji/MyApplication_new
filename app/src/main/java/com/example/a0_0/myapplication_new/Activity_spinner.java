package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity_spinner extends Activity implements TextWatcher{
    TextView tv;
    Spinner spinner;
    String[] items = {"北京市", "上海市", "广州市", "深圳市", "重庆市", "天津市", "武汉市", "西安市", "沈阳市", "长沙市", "珠海市"};
    String[]items2={"abcdgkja","abcsadf","abcfasd","afsda","afadsfa","afbadfadsf","badgas","chdre","chfdh","badagasdga"};
    AutoCompleteTextView auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        tv = (TextView) findViewById(R.id.tv);
        spinner = (Spinner) findViewById(R.id.spinner);
        auto=(AutoCompleteTextView)findViewById(R.id.auto);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        spinner.setAdapter(arrayAdapter);
/*        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(items[position]);
            }
        });//用OnItemClickListener不行，会提示不能用在spinner*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,items2);
        auto.setAdapter(adapter);
        auto.addTextChangedListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        tv.setText(auto.getText());
    }
}