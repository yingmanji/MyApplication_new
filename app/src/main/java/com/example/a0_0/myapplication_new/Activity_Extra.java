package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_Extra extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__extra);
    }
    public void go(View view)
    {
        Intent intent=new Intent(this,Activity_Extra.class);
        Bundle bundle=new Bundle();
        bundle.putString("001","Activity_Extra发来的数据");
        intent.putExtras(bundle);
        Intent itent=new Intent(Activity_Extra.this,ActivityB.class);
        startActivity(itent);
    }
}
