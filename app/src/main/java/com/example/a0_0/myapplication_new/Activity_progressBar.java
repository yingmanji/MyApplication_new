package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Random;

public class Activity_progressBar extends Activity {
    private ProgressBar pb;
    private Random random;
    private int curProgress;
    private int randomValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb=(ProgressBar)findViewById(R.id.pb);
        random=new Random();

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
                    pb.setProgress(curProgress);
                }
            }
        }).start();
    }

}
