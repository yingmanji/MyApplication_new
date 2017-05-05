package com.example.a0_0.myapplication_new.sqlite.service;

import com.example.a0_0.myapplication_new.model.Contact;

import java.util.List;

/**
 * Created by 樱满集0_0 on 2017/5/5.
 */

public interface ContactService {
    List<Contact> getALLContact();
    long add(Contact contact);
    long deleteContactByCid(int cid);
    long updateContentByCid(Contact contact);
}
