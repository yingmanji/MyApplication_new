package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class Activity_FragmentManager extends Activity {
    private Fragment fragment_one;
    private Fragment fragment_two;
    private int showState=0;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__fragment_manager);
        fragment_one=new Fragment();
        fragment_two=new Fragment();
        fragmentManager=getFragmentManager();
        transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.frame_fragmentManager,fragment_one);
        transaction.commit();
    }
    public void change(View view)
    {
        if(showState==0)
        {
            transaction.replace(R.id.frame_fragmentManager,fragment_two);
            showState=1;
        }
        else if(showState==1)
        {
            transaction.replace(R.id.frame_fragmentManager,fragment_one);
            showState=0;
        }
        transaction.commit();
    }
}
