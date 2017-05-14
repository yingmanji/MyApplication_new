package com.example.a0_0.myapplication_new;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.service.ContactService;
import com.example.a0_0.myapplication_new.sqlite.service.ContactServiceImpl;

public class ContactEditActivity extends Activity {
    private EditText et_cname,et_cphone;
    Contact getContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_edit);
        setContentView(R.layout.activity_contact_add);
        et_cname=(EditText)findViewById(R.id.et_cname);
        et_cphone=(EditText)findViewById(R.id.et_cphone);
        getContact=(Contact)getIntent().getSerializableExtra("editContact");
        et_cname.setText(getContact.getCname());
        et_cphone.setText(getContact.getCphone());
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
        long flag=service.updateContentByCid(new Contact(getContact.getCid(),cname,cphone));//将新的数据存入数据库
        if(flag>0)
        {
            Toast.makeText(this,"修改成功！",Toast.LENGTH_SHORT).show();
            Contact c=new Contact(getContact.getCid(),cname,cphone);
            Intent intent=new Intent();
            Bundle bundle=new Bundle();
            bundle.putSerializable("editContact",c);//Contact要实现Serializable接口,否则会报错
            intent.putExtras(bundle);
            setResult(0x212,intent);
            finish();
        }
        else
        {
            Toast.makeText(this,"修改失败！",Toast.LENGTH_SHORT).show();
        }
    }
    public void reset(View view)
    {
        et_cname.setText("");
        et_cphone.setText("");
    }
    public void cancel(View view)
    {
        setResult(0x211);
        finish();
    }
}
