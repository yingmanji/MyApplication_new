package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_FLAG_C extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__flag_c);
    }
    public void go(View view)
    {
        Intent intent=new Intent(this,Activity_FLAG_D.class);
        startActivity(intent);
    }
}
