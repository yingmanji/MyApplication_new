package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityLife extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("#:"+getClass().getSimpleName()+" onCreate");
        setContentView(R.layout.activity_life);
    }

    public void go(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("#:"+getClass().getSimpleName()+" onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("#:"+getClass().getSimpleName()+" onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("#:"+getClass().getSimpleName()+" onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("#:"+getClass().getSimpleName()+" onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("#:"+getClass().getSimpleName()+" onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("#:"+getClass().getSimpleName()+" onDestroy");
    }
}
