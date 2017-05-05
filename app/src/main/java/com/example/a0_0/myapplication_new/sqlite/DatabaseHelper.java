package com.example.a0_0.myapplication_new.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.a0_0.myapplication_new.model.Contact;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
    //在初次运行时执行，只执行一次,必须小心onCreate的内容只执行一次！必须确定SQL代码没有异常!暂时无法找到mydb.db位置
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
        SQLiteDatabase db=myInstance.getReadableDatabase();//获取数据库，假如没有就创建,此处理想结果为不需要创建
        ContentValues values=new ContentValues();
        System.out.println("###"+TB_NAME);
        values.put(FIELD_CNAME,contact.getCname());
        values.put(FIELD_CPHONE,contact.getCphone());
        System.out.println("###"+values);
        long flag=db.insert(TB_NAME,null,values);//返回受影响的行数
        return flag;//0和-1为失败
    }
    public List<Contact> getALLContact()
    {
        List<Contact> list=new ArrayList<>();
        SQLiteDatabase db=myInstance.getReadableDatabase();
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
}
