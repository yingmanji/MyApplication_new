package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityForResult extends Activity {
    private final int REQUEST_RESULT1=0x110;//定义请求码
    private final int REQUEST_RESULT2=0x120;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_result);
        tv=(TextView)findViewById(R.id.tv);
    }
    public void getResult(View view)
    {
        if(view.getId()==R.id.b1)
            startActivityForResult(new Intent(this,ActivityResult1.class),REQUEST_RESULT1);
        if(view.getId()==R.id.b2)
            startActivityForResult(new Intent(this,ActivityResult2.class),REQUEST_RESULT2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==REQUEST_RESULT1&&resultCode==ActivityResult1.RESULT_CODE){
            if(null!=intent){
                String result=intent.getStringExtra("key1");
                if(null!=result&&!"".equals(result))
                    tv.setText(result);
            }
        }
        if(requestCode==REQUEST_RESULT2&&resultCode==ActivityResult2.RESULT_CODE){
            if(null!=intent){
                String result=intent.getStringExtra("key2");
                if(null!=result&&!"".equals(result))
                    tv.setText(result);
            }
        }

    }
}
