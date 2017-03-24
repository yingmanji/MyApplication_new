package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Activity_call extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }
    public void call_list(View view)
    {
        Intent intent=new Intent(this,activity_list.class);
        startActivity(intent);
    }
    public void web(View view)
    {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")));
    }
    public void dial(View view)
    {
        startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel"+"13560375076")));
    }
}
