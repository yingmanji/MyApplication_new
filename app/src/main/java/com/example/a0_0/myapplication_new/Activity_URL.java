package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity_URL extends Activity {
    private TextView tv_data;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__url);
        tv_data=(TextView)findViewById(R.id.tv_data);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0x110)
                {
                    tv_data.setText(msg.obj.toString());
                }
            }
        };
    }
    public void getNetData(View view)
    {
        new Thread(new Runnable() {//主线程不能访问网络
            @Override
            public void run() {
                //建立URL对象
                URL url=null;
                try {
                    url=new URL("https://www.baidu.com");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                //建立HttpURLConnection对象
                HttpURLConnection connection =null;
                try {
                    connection =(HttpURLConnection) url.openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    InputStreamReader inputStreamReader=new InputStreamReader(connection.getInputStream());
                    BufferedReader reader=new BufferedReader(inputStreamReader);
                    String result="";
                    String line="";
                    while((line=reader.readLine())!=null)
                    {
                        result+=line;
                    }
                    reader.close();
                    Message message=new Message();
                    message.what=0x110;
                    if(result!=null&&result!="")
                    {
                        //tv_data.setText(result);
                        message.obj=result;
                    }
                    else
                    {
                        //tv_data.setText("error");
                        message.obj="error";
                    }
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
