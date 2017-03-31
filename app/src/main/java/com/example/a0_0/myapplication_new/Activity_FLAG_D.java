package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_FLAG_D extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__flag_d);
    }
    public void go(View view)
    {
        Intent intent=new Intent(this,Activity_FLAG_B.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);//a b c d b
        //intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);//a b c d b
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//a b清除b前面的栈顶，b就变成了栈顶
        //intent.setFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);//a b c d b
        //intent.setFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);//a b c d b
        startActivity(intent);
    }
}
