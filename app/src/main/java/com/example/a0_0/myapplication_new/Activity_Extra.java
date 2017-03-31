package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a0_0.myapplication_new.model.myMap;
import com.example.a0_0.myapplication_new.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Activity_Extra extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__extra);
    }
    public void go(View view)
    {
        Intent intent=new Intent(this,ActivityB.class);
        /*Bundle bundle=new Bundle();
        bundle.putString("001","Activity_Extra发来的数据");
        intent.putExtras(bundle);*/
        intent.putExtra("myInt",001);
        intent.putExtra("myStr","工贸");
        int[] intArray=new int[]{1,2,3,4,5};
        intent.putExtra("myArray",intArray);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("abc");
        arrayList.add("bcd");
        arrayList.add("cde");
        intent.putStringArrayListExtra("myList",arrayList);
        myMap myMap=new myMap();
        Map<String,String> map= new HashMap<>();
        map.put("mkey1","guangzhou");
        map.put("mkey2","beijing");
        myMap.setMap(map);
        intent.putExtra("myMap",myMap);
        User user=new User("0001","张三");
        User user2=new User(1,"李四");
        intent.putExtra("myUser2",user2);
     /*   Bundle bundle=new Bundle();
        bundle.putSerializable("myUser",user);
        intent.putExtras(bundle);*/
        Bundle bundle=new Bundle();
        bundle.putParcelable("myUser",user2);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
