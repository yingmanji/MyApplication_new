package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.a0_0.myapplication_new.model.MyMap;
import com.example.a0_0.myapplication_new.model.User;

import java.util.ArrayList;
import java.util.Map;

public class ActivityB extends Activity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        tv=(TextView)findViewById(R.id.tv);
        Intent intent=this.getIntent();
/*        Bundle bundle=intent.getExtras();
        String s=bundle.getString();*/
        int myInt=intent.getIntExtra("myInt",0);//先给一个默认值，假如接收不到参数，就显示默认值0
        String myStr= intent.getStringExtra("myStr");
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(myInt);
        stringBuilder.append(" ");
        stringBuilder.append(myStr);
        tv.setText(stringBuilder.toString());
        System.out.println("result:"+myInt+"  "+myStr);
        int[]intArray=intent.getIntArrayExtra("myArray");
        for(int x:intArray)
        {
            System.out.println(x);
        }
        ArrayList<String> arrayList=intent.getStringArrayListExtra("myList");
        for(String x:arrayList)
        {
            System.out.println(x);
        }
        /*User user=(User)intent.getExtras().getSerializable("myUser");//接收的是Serializable类型的参数，需要强转为User型
        if(null!=user)
            System.out.println("user:"+user.getUserId()+"  "+user.getUserName());*/
        MyMap myMap=(MyMap) intent.getSerializableExtra("myMap");//注意强转最好后写，否则不会提词
        if(null!=myMap)
            System.out.println("map:"+myMap.getMap().get("mkey1")+"  "+myMap.getMap().get("mkey2"));
        User user2=intent.getParcelableExtra("myUser2");
        if(null!=user2)
            System.out.println("user2:"+user2.getIntId()+"  "+user2.getUserName());
        User user_parecel_bundle=(User) intent.getExtras().getParcelable("myUser");//用Bundle及Parcel来进行Activity数据交互
        System.out.println(user_parecel_bundle.getIntId()+"  "+user_parecel_bundle.getUserName());
    }
}
