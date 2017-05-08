package com.example.a0_0.myapplication_new.sqlite.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 樱满集0_0 on 2017/5/5.
 */

public class ContactServiceImpl implements ContactService{
    private DatabaseHelper databaseHelper;
    public ContactServiceImpl(Context context)
    {
        databaseHelper=DatabaseHelper.getInstance(context);
    }

    public long add(Contact contact)
    {
        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        System.out.println("###"+DatabaseHelper.TB_NAME);
        values.put(DatabaseHelper.FIELD_CNAME,contact.getCname());
        values.put(DatabaseHelper.FIELD_CPHONE,contact.getCphone());
        System.out.println("###"+values);
        long flag=db.insert(DatabaseHelper.TB_NAME,null,values);//返回受影响的行数
        return flag;//0和-1为失败
    }
    public List<Contact> getALLContact()
    {
        List<Contact> list=new ArrayList<>();
        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        Cursor cursor=null;
        try
        {
            cursor=db.rawQuery("select * from "+DatabaseHelper.TB_NAME,null);//能用常量尽量用常量,第二个参数可以new一个字符串数组
            if(cursor!=null&&cursor.moveToFirst())//判断是否可以移动到第一条
            {
                do{
                    //cursor.getColumnCount();//列的个数，字段的个数
                    Contact contact=new Contact();
//                    contact.setCid(cursor.getInt(0));//获取cid并设置到模型类Contact中
                    contact.setCid(cursor.getInt(cursor.getColumnIndex("cid")));//用数字虽然简单，但是不够直观
//                    contact.setCname(cursor.getString(1));//获取cname
//                    contact.setCphone(cursor.getString(2));//获取cphone
                    contact.setCname(cursor.getString(cursor.getColumnIndex("cname")));
                    contact.setCphone(cursor.getString(cursor.getColumnIndex("cphone")));
                    list.add(contact);
                }
                while(cursor.moveToNext());//判断是否可以移动到最后一条，判断是否结束
            }
        }
        catch(Exception e)
        {
            System.out.println("#查询失败"+e.toString());
        }
        finally
        {
            if(cursor!=null) {
                cursor.close();//关闭游标
            }
        }
        return list;
    }

    @Override
    public long deleteContactByCid(int cid) {
        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        db.execSQL("delete from"+DatabaseHelper.TB_NAME+" where cid = "+cid);
        return 0;
    }

    @Override
    public long updateContentByCid(Contact contact) {
        SQLiteDatabase db=databaseHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.FIELD_CID,contact.getCid());
        values.put(DatabaseHelper.FIELD_CNAME,contact.getCname());
        values.put(DatabaseHelper.FIELD_CPHONE,contact.getCphone());
        long flag=db.update(DatabaseHelper.TB_NAME,values,DatabaseHelper.FIELD_CID+" = ? ",new String[]{String.valueOf(contact.getCid())});
        return flag;
    }
}
