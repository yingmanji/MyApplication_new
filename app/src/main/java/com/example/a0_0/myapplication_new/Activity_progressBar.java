package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.example.a0_0.myapplication_new.model.User;

import java.util.Random;

import java.util.logging.LogRecord;

public class Activity_progressBar extends Activity {
    private ProgressBar pb;
    private Random random;
    private int curProgress;
    private int randomValue;
    private Handler handler;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb=(ProgressBar)findViewById(R.id.pb);
        user=new User();
        random=new Random();
        handler=new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x110)
                {
                    System.out.println("aaa:"+user.getUserName());
                    pb.setProgress(msg.arg1);//curProgress
                }
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    randomValue=random.nextInt(10);
                    curProgress+=randomValue;
//                  pb.setProgress(curProgress);//在早期的Android studio中只有UI线程可以控制View控件
                    Message msg=new Message();
                    msg.what=0x110;//要发送的地址
                    msg.arg1=curProgress;//要发送的内容
                    handler.sendMessage(msg);
//                    handler.sendEmptyMessage(0x110);

                }
            }
        }).start();
    }

}
