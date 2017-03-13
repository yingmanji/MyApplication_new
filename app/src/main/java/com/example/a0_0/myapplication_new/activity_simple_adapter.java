package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class activity_simple_adapter extends Activity {
    private static final String[]items1={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private static final String[]items2={"北京市2","上海市2","广州市2","深圳市2","重庆市2","天津市2","武汉市2","西安市2","沈阳市2","长沙市2","珠海市2"};
    private static final int[]imgIds={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private TextView textView1;
    private TextView textView2;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);



        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        List<Map<String,String>>data=new ArrayList<>();

        for(int i=0;i<items1.length;i++){
            Map<String,String> map=new HashMap< >();
            map.put("img",String.valueOf(imgIds[i]));
            map.put("tv1",items1[i]);
            map.put("tv2",items2[i]);
            data.add(map);
        }
        listView=(ListView)findViewById(R.id.listView);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,data,R.layout.item,new String[]{"img","tv1","tv2"},
                new int[]{R.id.img,R.id.textView1,R.id.textView2});
        listView.setAdapter(simpleAdapter);
    }
}
