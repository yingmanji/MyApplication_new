package com.example.a0_0.myapplication_new.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a0_0.myapplication_new.model.Contact;

import java.io.FileNotFoundException;

/**
 * Created by 樱满集0_0 on 2017/5/2.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="mydb.db";
    public static final int DB_VERSION=1;
    public static final String TB_NAME="contact";
    public static final String FIELD_CID="cid";
    public static final String FIELD_CNAME="cname";
    public static final String FIELD_CPHONE="cphone";
    //设置FIELD_CID为主键，并自动增长
    public static final String SQL="create table "+TB_NAME+"("+
            FIELD_CID+" integer primary key autoincrement,"+
            FIELD_CNAME +" text,"+
            FIELD_CPHONE+" text" +
            ")";
    private static DatabaseHelper myInstance;
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    //单例模式
    public static synchronized DatabaseHelper getInstance(Context context)
    {
        if(myInstance==null)
        {
            myInstance=new DatabaseHelper(context.getApplicationContext());
        }
        return myInstance;
    }
    //在初次运行时执行，只执行一次,必须小心onCreate的内容只执行一次！必须确定SQL代码没有异常！
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            System.out.println("#"+SQL.toString());
            db.execSQL(SQL);//建议做异常处理
        }
        catch (Exception e)
        {
            System.out.println("！#这是异常");
        }
        System.out.println("#执行SQL语句");
    }
    //数据表结构发生改变
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //修改数据表结构语句
        System.out.println("#执行SQL语句");
    }
    public long add(Contact contact)
    {
        SQLiteDatabase db=myInstance.getReadableDatabase();
        ContentValues values=new ContentValues();
        System.out.println("###"+TB_NAME);
        values.put(FIELD_CNAME,contact.getCname());
        values.put(FIELD_CPHONE,contact.getCphone());
        System.out.println("###"+values);
        long flag=db.insert(TB_NAME,null,values);//返回受影响的行数
        return flag;//0和-1为失败
    }
}
