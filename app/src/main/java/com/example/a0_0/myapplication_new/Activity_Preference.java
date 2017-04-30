package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity_Preference extends Activity {
    private TextView tv_pre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__preference);
        tv_pre=(TextView)findViewById(R.id.tv_pre);


        SharedPreferences mSettings=getSharedPreferences("mSettings",MODE_PRIVATE);
        //获取颜色值 key-vallue
        String color=mSettings.getString("myColor","#ffffff");

        tv_pre.setBackgroundColor(Color.parseColor(color));
    }
    public void dealColor(View view)
    {
        if(view.getId()==R.id.btn_set1)
        {
            SharedPreferences mSettings=getSharedPreferences("mSettings",MODE_PRIVATE);
            SharedPreferences.Editor editor=mSettings.edit();//开启编辑器
            editor.putString("myColor","#aabb00");//也可以 editor.putString("myColor","#aabb00").apply();
            editor.apply();
            tv_pre.setBackgroundColor(Color.parseColor("#aabb00"));
        }
        else if(view.getId()==R.id.btn_set2)
        {
            SharedPreferences mSettings=getSharedPreferences("mSettings",MODE_PRIVATE);
            SharedPreferences.Editor editor=mSettings.edit();//开启编辑器
            editor.putString("myColor","#ffbb00");//也可以 editor.putString("myColor","#aabb00").apply();
            editor.apply();
            tv_pre.setBackgroundColor(Color.parseColor("#ffbb00"));
        }
        else if(view.getId()==R.id.btn_clear)
        {
            SharedPreferences mSettings=getSharedPreferences("mSettings",MODE_PRIVATE);
            SharedPreferences.Editor editor=mSettings.edit();//开启编辑器
            editor.remove("myColor");//删除单个key
            //editor.clear();//把当前文档所有的key删除
            editor.apply();
            tv_pre.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }
}
