package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.service.ContactService;
import com.example.a0_0.myapplication_new.sqlite.service.ContactServiceImpl;

public class ContactAddActivity extends Activity {
    private EditText et_cname,et_cphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_add);
        et_cname=(EditText)findViewById(R.id.et_cname);
        et_cphone=(EditText)findViewById(R.id.et_cphone);
    }
    public void save(View view)
    {
        String cname=et_cname.getText().toString().trim();
        String cphone=et_cphone.getText().toString().trim();
        if(cname.equals("")||cname==null)
        {
            Toast.makeText(this,"姓名不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        if(cphone.equals("")||cphone==null)
        {
            Toast.makeText(this,"手机号不能为空！",Toast.LENGTH_SHORT).show();
            return;
        }
        ContactService service=new ContactServiceImpl(this);
        long flag=service.add(new Contact(cname,cphone));
        if(flag>0)
        {
            Toast.makeText(this,"添加成功！",Toast.LENGTH_SHORT).show();
            Contact c=new Contact((int)flag,cname,cphone);
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            bundle.putSerializable("newContact",c);
            intent.putExtras(bundle);
            setResult(0x112,intent);
            finish();
        }
        else
        {
            Toast.makeText(this,"添加失败！",Toast.LENGTH_SHORT).show();
        }
    }
    public void reset(View view)
    {
        et_cname.setText("");
        et_cphone.setText("");
    }
    public void cancel(View view)
    {
        setResult(0x111);
        finish();
    }
}
