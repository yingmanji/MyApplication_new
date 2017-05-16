package com.example.a0_0.myapplication_new.service;

import android.app.ActivityManager;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16.
 */

public class MyResultService extends IntentService {
    public MyResultService()
    {
        super("resultService");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        System.out.println("运行了");
        if (intent != null) {
            String strValue = intent.getStringExtra("myRskey");
            ResultReceiver receiver = (ResultReceiver) intent.getExtras().get("myReceiver");
            System.out.println("#"+strValue);
            try {
                Thread.sleep(2000);//使线程休眠2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString("myKey", "这是Service返回来的信息");
            receiver.send(0x120, bundle);
        }
    }
}
