package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivityResult1 extends Activity {
    public static final int RESULT_CODE=0x111;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        et=(EditText)findViewById(R.id.et);
    }
    public void back(View view)
    {
        Intent intent=new Intent();
        intent.putExtra("key1",et.getText().toString());
        setResult(RESULT_CODE,intent);
        finish();
    }
}
