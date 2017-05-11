package com.example.a0_0.myapplication_new.model;

import java.io.Serializable;

/**
 * Created by 樱满集0_0 on 2017/5/2.
 */

public class Contact implements Serializable {
    private int cid;
    private String cname;
    private String cphone;

    public Contact() {
    }

    public Contact(String cname, String cphone) {
        this.cname = cname;
        this.cphone = cphone;
    }

    public Contact(int cid, String cname, String cphone) {
        this.cid = cid;
        this.cname = cname;
        this.cphone = cphone;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    @Override
    public String toString() {
        return "Contact:[" +
                 cid +
                "," + cname +
                "," + cphone +"]";
    }
}
