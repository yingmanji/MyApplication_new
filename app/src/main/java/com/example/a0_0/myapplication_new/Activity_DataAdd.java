package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.DatabaseHelper;
import com.example.a0_0.myapplication_new.sqlite.service.ContactService;
import com.example.a0_0.myapplication_new.sqlite.service.ContactServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Activity_DataAdd extends AppCompatActivity {
    private ListView lv_contact;
    private ContactService contactService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__data_add);
        lv_contact=(ListView)findViewById(R.id.lv_contact);
        contactService=new ContactServiceImpl(this);
        List<Map<String,String>> data=new ArrayList<>();//定义data
        List<Contact> list=contactService.getALLContact();//获取数据库数据
        for(Contact c:list)
        {
            Map<String,String> map=new HashMap<>();
            map.put(DatabaseHelper.FIELD_CID,String.valueOf(c.getCid()));
            map.put(DatabaseHelper.FIELD_CNAME,String.valueOf(c.getCname()));
            map.put(DatabaseHelper.FIELD_CPHONE,String.valueOf(c.getCphone()));
        }
        //创建适配器
        SimpleAdapter adapter=
                new SimpleAdapter(this,data,R.layout.activity__datashow,new String[]{DatabaseHelper.FIELD_CID,DatabaseHelper.FIELD_CNAME,DatabaseHelper.FIELD_CPHONE},
    new int[]{R.id.tv_cid,R.id.tv_cname,R.id.tv_cphone});
        //设置适配器
        lv_contact.setAdapter(adapter);
    }
    public void initData()
    {
        Resources resources=getResources();
        String[] names=resources.getStringArray(R.array.ContactNames);
        String[] phones=resources.getStringArray(R.array.ContactPhones);
        for(int i=0;i<names.length;i++)
        {
            contactService.add(new Contact(names[i],phones[i]));
        }
    }
}
