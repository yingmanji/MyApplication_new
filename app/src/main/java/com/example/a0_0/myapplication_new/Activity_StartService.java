package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a0_0.myapplication_new.service.MyService;

public class Activity_StartService extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__start_service);
    }
    public void startService(View view)
    {
        Intent intent=new Intent(this, MyService.class);
        intent.putExtra("myKey","Service");
        startService(intent);
    }
}
