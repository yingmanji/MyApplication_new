package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

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
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb=(ProgressBar)findViewById(R.id.pb);
        random=new Random();
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(curProgress<100)
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
                            user=new User();
                            msg.what=0x110;//要发送的地址
                            msg.arg1=curProgress;//要发送的内容
                            msg.obj=user;
                            handler.sendMessage(msg);
//                    handler.sendEmptyMessage(0x110);
                        }
                    }
                }).start();

            }
        });
        handler=new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x110)
                {
                    user=(User)msg.obj;
                    System.out.println("aaa:"+user.getUserName());
                    pb.setProgress(msg.arg1);//curProgress
                    textView.setText(user.getUserName());
                }
            }
        };


    }

}
