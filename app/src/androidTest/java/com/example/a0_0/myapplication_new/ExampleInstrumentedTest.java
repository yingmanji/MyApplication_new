package com.example.a0_0.myapplication_new;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.DatabaseHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        DatabaseHelper helper=DatabaseHelper.getInstance(appContext);
        helper.getReadableDatabase();
        System.out.println("##"+helper.getDatabaseName());
//        Contact contact=new Contact("zhang","18888888888");
//        Contact contact=new Contact("wang","13333333333");
        Contact contact=new Contact("li","12222222222");
        long flag=helper.add(contact);
        if(flag>0)
        {
            System.out.println("#成功");
        }
        else
        {
            System.out.println("#失败");
        }
        List<Contact> list=helper.getALLContact();
        for(Contact c:list)
        {
            System.out.println("#"+c);
        }
//        assertEquals("com.example.a0_0.myapplication_new", appContext.getPackageName());
    }
}
