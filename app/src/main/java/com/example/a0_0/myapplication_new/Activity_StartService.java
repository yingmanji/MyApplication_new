package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Toast;

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
        intent.putExtra("myKey","Service");*/
        Intent intent=new Intent(this, MyResultService.class);
        intent.putExtra("myRsKey","resultService");
        intent.putExtra("myReceiver",receiver);//该方法本身不存在
        startService(intent);
    }
    private ResultReceiver receiver=new ResultReceiver(new Handler()){
        //重写onReceiveResult方法

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            if(resultCode==0x120&&resultData!=null)
            {
                Toast.makeText(Activity_StartService.this,resultData.getString("myKey","获取消息失败！"),Toast.LENGTH_SHORT).show();
            }
        }
    };
}
