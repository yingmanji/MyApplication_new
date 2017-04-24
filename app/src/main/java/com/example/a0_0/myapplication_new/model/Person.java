package com.example.a0_0.myapplication_new.model;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Person {
    private String name;
    private int age;
    private String getName()
    {
        return name;
    }
    public void setName(String naem0)
    {
        this.name=name;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge()
    {
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
