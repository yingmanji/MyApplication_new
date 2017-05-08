package com.example.a0_0.myapplication_new;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.a0_0.myapplication_new.model.Contact;
import com.example.a0_0.myapplication_new.sqlite.service.ContactService;
import com.example.a0_0.myapplication_new.sqlite.service.ContactServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


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
//        DatabaseHelper helper=DatabaseHelper.getInstance(appContext);
        ContactService contactService=new ContactServiceImpl(appContext);
//        helper.getReadableDatabase();//用了代理以后可以不要，不是因为有了代理，而是数据库之前创建过了
//        System.out.println("##"+helper.getDatabaseName());
//        Contact contact=new Contact("zhang","18888888888");
//        Contact contact=new Contact("wang","13333333333");
//        Contact contact=new Contact("chen","15555555555");
/*        Resources resources=appContext.getResources();
        String[] names=resources.getStringArray(R.array.ContactNames);
        String[] phones=resources.getStringArray(R.array.ContactPhones);
        for(int i=0;i<names.length;i++)
        {
            contactService.add(new Contact(names[i],phones[i]));
        }
        contactService.updateContentByCid(new Contact(1,"wang","1999999999"));*/
        contactService.deleteContactByCid(4);
       /* long flag=contactService.add(contact);
        if(flag>0)
        {
            System.out.println("#成功");
        }
        else
        {
            System.out.println("#失败");
        }*/
        List<Contact> list=contactService.getALLContact();
        for(Contact c:list)
        {
            System.out.println("#"+c);
        }
//        assertEquals("com.example.a0_0.myapplication_new", appContext.getPackageName());
    }
}
