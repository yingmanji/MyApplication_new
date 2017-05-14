package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.DatabaseHelper;
import com.example.a0_0.myapplication_new.sqlite.service.ContactService;
import com.example.a0_0.myapplication_new.sqlite.service.ContactServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactActivity extends Activity {
    private ListView lv_contact;
    private ContactService contactService;
    List<Map<String,String>> data;
    SimpleAdapter adapter;
    int currentPosition=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__data_add);
        lv_contact=(ListView)findViewById(R.id.lv_contact);
        contactService=new ContactServiceImpl(this);//创建service对象
//        initData();//初始化数据
        initAdapter();
        registerForContextMenu(lv_contact);//给listView的lv_contact注册ContextMenu,注册上下文菜单
    }
    private void initData()
    {

        Resources resources=getResources();
        String[] names=resources.getStringArray(R.array.ContactNames);
        String[] phones=resources.getStringArray(R.array.ContactPhones);
        for(int i=0;i<names.length;i++)
        {
            contactService.add(new Contact(names[i],phones[i]));
        }
        System.out.println("#运行了");
    }
    public void addContact(View view)
    {
        startActivityForResult(new Intent(ContactActivity.this,ContactAddActivity.class),0x110);//跳转到ContactAddActivity
    }
    //重写onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("操作联系人");
        menu.add(0,1,0,"修改");
        menu.add(0,2,0,"删除");
        //super.onCreateContextMenu(menu, v, menuInfo);
    }
    //为ContextMenu添加响应事件
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Contact c=new Contact();
        AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        currentPosition=info.position;
        c.setCid(Integer.parseInt(data.get(currentPosition).get("cid")));
        c.setCname(data.get(currentPosition).get("cname"));
        c.setCphone(data.get(currentPosition).get("cphone"));
        switch (item.getItemId())
        {
            case 1:
                Intent intent=new Intent(this,ContactEditActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("editContact",c);
                intent.putExtras(bundle);
                startActivityForResult(intent,0x210);
//                Toast.makeText(this,"1",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                long flag=contactService.deleteContactByCid(c.getCid());
                if(flag==0)
                {
                    data.remove(currentPosition);
                    adapter.notifyDataSetChanged();
                }
                //Toast.makeText(this,"2",Toast.LENGTH_SHORT).show();
                break;
            default:super.onMenuItemSelected(featureId,item);
        }
        return super.onMenuItemSelected(featureId, item);
    }

    protected void onActivityResult(int resquestCode, int resultCode, Intent intent)
    {
        if(resquestCode==0x110&&resultCode==0x112)
        {
            //initAdapter();
            Contact c=(Contact)intent.getExtras().getSerializable("newContact");
            Map<String,String> map=new HashMap<>();
            map.put(DatabaseHelper.FIELD_CID,String.valueOf(c.getCid()));
            map.put(DatabaseHelper.FIELD_CNAME,String.valueOf(c.getCname()));
            map.put(DatabaseHelper.FIELD_CPHONE,String.valueOf(c.getCphone()));
            data.add(map);
            adapter.notifyDataSetChanged();//当数据变化时更新Adapter
        }
        if(resquestCode==0x210&&resultCode==0x212&&intent!=null)
        {
            //initAdapter();
            Contact c=(Contact)intent.getExtras().getSerializable("editContact");
            data.get(currentPosition).put(DatabaseHelper.FIELD_CNAME,c.getCname());
            data.get(currentPosition).put(DatabaseHelper.FIELD_CPHONE,c.getCphone());
            /*Map<String,String> map=new HashMap<>();
            map.put(DatabaseHelper.FIELD_CID,String.valueOf(c.getCid()));
            map.put(DatabaseHelper.FIELD_CNAME,String.valueOf(c.getCname()));
            map.put(DatabaseHelper.FIELD_CPHONE,String.valueOf(c.getCphone()));
            data.add(map);*/
            adapter.notifyDataSetChanged();//当数据变化时更新Adapter
        }
        if(resquestCode==0x110&&resultCode==0x111)
        {

        }
    }
    private void initAdapter()
    {
        data=new ArrayList<>();//定义data
        List<Contact> list=contactService.getALLContact();//获取数据库数据
        for(Contact c:list)
        {
            Map<String,String> map=new HashMap<>();
            map.put(DatabaseHelper.FIELD_CID,String.valueOf(c.getCid()));
            map.put(DatabaseHelper.FIELD_CNAME,String.valueOf(c.getCname()));
            map.put(DatabaseHelper.FIELD_CPHONE,String.valueOf(c.getCphone()));
            data.add(map);
        }
        //创建适配器
        adapter=
                new SimpleAdapter(this,data,R.layout.contact_item,new String[]{DatabaseHelper.FIELD_CID,DatabaseHelper.FIELD_CNAME,DatabaseHelper.FIELD_CPHONE},
                        new int[]{R.id.tv_cid,R.id.tv_cname,R.id.tv_cphone});
        //设置适配器
        lv_contact.setAdapter(adapter);
    }
}
