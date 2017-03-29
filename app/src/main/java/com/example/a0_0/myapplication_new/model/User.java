package com.example.a0_0.myapplication_new.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/**
 * Created by 樱满集0_0 on 2017/3/6.
 */

public class User implements Parcelable {//implements Serializable一般用于持久化的数据传输如A--B--C--D,Parcelable用于短暂的数据传输,某些情况下,比Serializable更有效率
    private int intId;
    private String userId;
    private String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.intId=0;
    }

    public User(int intId, String userName) {
        this.intId = intId;
        this.userName = userName;
        this.userId=null;
    }

    protected User(Parcel in)
    {
        intId=in.readInt();
        userName=in.readString();
    }

    public static final Creator<User> CREATOR=new Creator<User>() {//用Parcelable接口还要有Creator静态常量
        @Override
        public User createFromParcel(Parcel in) {//相当于反序列化
            return new User(in.readInt(),in.readString());
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getIntId() {
        return intId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public User() {
        userId="001";
        userName="yingmanji";
        intId=0;
    }

    @Override
    public int describeContents() {//实现Parcelable接口要另外实现以下两个方法
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {//相当于序列化，注意类型要对应，顺序也不能乱
        parcel.writeInt(intId);
        parcel.writeString(userName);
    }
}
