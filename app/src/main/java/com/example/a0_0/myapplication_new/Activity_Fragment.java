package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Fragment extends Activity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__fragment);
        tv1=(TextView) findViewById(R.id.tv1);
        tv2=(TextView) findViewById(R.id.tv2);
    }
    public void change(View view)
    {
        if(view.getId()==R.id.btn1)
        {
            tv1.setVisibility(view.VISIBLE);
            tv2.setVisibility(View.INVISIBLE);
        }
        else if(view.getId()==R.id.btn3) {
            tv1.setVisibility(view.INVISIBLE);
            tv2.setVisibility(View.VISIBLE);
        }
    }
}
