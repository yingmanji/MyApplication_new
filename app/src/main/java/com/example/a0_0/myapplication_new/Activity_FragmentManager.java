package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.a0_0.myapplication_new.fragments.Fragment_one;
import com.example.a0_0.myapplication_new.fragments.Fragment_two;

public class Activity_FragmentManager extends Activity {
    private Fragment_one fragment_one;
    private Fragment_two fragment_two;
    private int showState=0;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__fragment_manager);
        fragment_one=new Fragment_one();
        fragment_two=new Fragment_two();
        fragmentManager=getFragmentManager();
        transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.frame_fragmentmanager,fragment_one);
        transaction.commit();
    }
    public void change(View view)
    {
        FragmentManager fragmentManager=getFragmentManager();//必须要有
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(showState==0)
        {
            transaction.replace(R.id.frame_fragmentmanager,fragment_two);
            showState=1;
        }
        else if(showState==1)
        {
            transaction.replace(R.id.frame_fragmentmanager,fragment_one);
            showState=0;
        }
        transaction.commit();
    }
}
