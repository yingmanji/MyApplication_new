package com.example.a0_0.myapplication_new.model;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Test {
    public static void main( String args[])
    {
        String jsonData="('name':'zhang','age':20,'grade':{'grade':'java','score':90})";
        Gson gson=new Gson();
        Student student=gson.fromJson(jsonData,Student.class);
        System.out.println(student);
    }
}
