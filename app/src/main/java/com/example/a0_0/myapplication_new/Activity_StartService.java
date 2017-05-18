package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Toast;

import com.example.a0_0.myapplication_new.service.BroadcastService;
import com.example.a0_0.myapplication_new.service.MyResultService;
import com.example.a0_0.myapplication_new.service.MyService;

public class Activity_StartService extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__start_service);
    }
    public void startService(View view)
    {
        /*Intent intent=new Intent(this, MyService.class);
        intent.putExtra("myKey","Service");
        startService(intent);*/
        /*Intent intent=new Intent(this, MyResultService.class);
        intent.putExtra("myRsKey","resultService");
        intent.putExtra("myReceiver",receiver);
        startService(intent);*/
        Intent intent=new Intent(this, BroadcastService.class);
        intent.putExtra("myKey","testBroadcastService");
        startService(intent);
        startActivity(new Intent(this,BroadcastActivity.class));
    }
    /*private ResultReceiver receiver=new ResultReceiver(new Handler()){
        //重写onReceiverResult

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if(resultCode==0x120&&resultData!=null)
            {
                Toast.makeText(Activity_StartService.this,resultData.getString("myKey","获取消息失败"),Toast.LENGTH_SHORT).show();
            }
        }
    };*/
    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent!=null)
            {
                int resultCode=intent.getIntExtra("resultCode",0);
                if(resultCode==0x110)
                {
                    String broadcastValue=intent.getStringExtra("myBroadcast");
                    Toast.makeText(context,broadcastValue,Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter=new IntentFilter(BroadcastService.ACTION);
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
