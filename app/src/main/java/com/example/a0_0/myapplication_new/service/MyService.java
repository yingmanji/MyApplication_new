package com.example.a0_0.myapplication_new.service;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Intent;

import java.util.List;

/**
 * Created by Administrator on 2017/5/15.
 */

public class MyService extends IntentService {
    public MyService()
    {
        super("test");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        String value = intent.getStringExtra("mykey");
        if (value != null && value != "") {
            System.out.println("#" + value);
        }
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> list = am.getRunningServices(40);
        for (ActivityManager.RunningServiceInfo info : list) {
            System.out.println("#"+info.service.getClassName());
        }
    }
}
