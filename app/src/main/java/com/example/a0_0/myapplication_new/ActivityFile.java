package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivityFile extends Activity {
    private EditText et_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        et_info=(EditText)findViewById(R.id.et_info);
        ((WebView)findViewById(R.id.wv)).loadUrl("file:///android_asset/index.html");
    }
    public void dealFile(View view)
    {
        BufferedReader reader=null;
        String result="";
        try {
            InputStreamReader inputStreamReader=new InputStreamReader(getAssets().open("mytext"));
            if(null!=inputStreamReader){
                try {
                    reader = new BufferedReader(inputStreamReader);
                    if (null != reader) {
                        StringBuilder builder = new StringBuilder();
                        String line = reader.readLine();
                        while (line != null) {
                            builder.append(line + "\n");
                            line = reader.readLine();
                        }
                        result = builder.toString();
                    }
                }
                finally {
                    reader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        et_info.setText(result);
    }
}
