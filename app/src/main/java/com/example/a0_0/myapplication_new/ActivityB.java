package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Bundle bundle=this.getIntent().getExtras();
        tv=(TextView)findViewById(R.id.tv);
        tv.setText(bundle.getString("001"));
    }
}
