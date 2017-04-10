package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.a0_0.myapplication_new.fragments.Fragment_ChatOne;
import com.example.a0_0.myapplication_new.fragments.Fragment_ChatTwo;

public class Activity_FragmentChat extends Activity {
    private Fragment_ChatOne fragment_chatOne;
    private Fragment_ChatTwo fragment_chatTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__fragment_chat);
        fragment_chatOne=new Fragment_ChatOne();
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        if(null!=fragment_chatOne) {
            Bundle bundle=new Bundle();
            bundle.putString("key_one","这是Fragment_ChatOne由Activity发出...");
            fragment_chatOne.setArguments(bundle);
            transaction.add(R.id.fl, fragment_chatOne);
        }
        transaction.commit();
    }
    public void change(View view)
    {
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        if(view.getId()==R.id.btn1)
        {
            if(fragment_chatOne==null)
            {
                fragment_chatOne=new Fragment_ChatOne();
                transaction.add(R.id.fl,fragment_chatOne);
            }
            transaction.replace(R.id.fl,fragment_chatOne);
        }
        else if(view.getId()==R.id.btn2)
        {
            if(fragment_chatTwo==null)
            {
                fragment_chatTwo=new Fragment_ChatTwo();
                fragment_chatTwo.getStr("这是fragment_charTwo，直接显示");
                transaction.add(R.id.fl,fragment_chatTwo);
            }
            transaction.replace(R.id.fl,fragment_chatTwo);
        }
        transaction.commit();
    }
}
