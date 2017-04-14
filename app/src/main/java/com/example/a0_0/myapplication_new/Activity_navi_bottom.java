package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.a0_0.myapplication_new.fragments.Fragment_fx;
import com.example.a0_0.myapplication_new.fragments.Fragment_txl;
import com.example.a0_0.myapplication_new.fragments.Fragment_wd;
import com.example.a0_0.myapplication_new.fragments.Fragment_wx;

public class Activity_navi_bottom extends Activity implements RadioGroup.OnCheckedChangeListener {
    private Fragment_wx fragment_wx=null;
    private Fragment_txl fragment_txl=null;
    private Fragment_fx fragment_fx=null;
    private Fragment_wd fragment_wd=null;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_bottom);
        fragment_wx=new Fragment_wx();
        rg=(RadioGroup)(findViewById(R.id.rg));
        rg.setOnCheckedChangeListener(this);
        ((RadioButton)findViewById(R.id.rb_wx)).setTextColor(Color.GREEN);
        getFragmentManager().beginTransaction().replace(R.id.fl,fragment_wx).commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        if (checkedId == R.id.rb_wx) {
            if(fragment_wx==null)
            {
                fragment_wx=new Fragment_wx();
            }
            ((RadioButton)findViewById(R.id.rb_wx)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,fragment_wx);
        } else if(checkedId==R.id.rb_txl)
        {
            if(fragment_txl==null)
            {
                fragment_txl=new Fragment_txl();
            }
            ((RadioButton)findViewById(R.id.rb_txl)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,fragment_txl);
        }
        else if(checkedId==R.id.rb_fx)
        {
            if(fragment_fx==null)
            {
                fragment_fx=new Fragment_fx();
            }
            ((RadioButton)findViewById(R.id.rb_fx)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,fragment_fx);
        }
        else if(checkedId==R.id.rb_wd)
        {
            if(fragment_wd==null)
            {
                fragment_wd=new Fragment_wd();
            }
            ((RadioButton)findViewById(R.id.rb_wd)).setTextColor(Color.GREEN);
            transaction.replace(R.id.fl,fragment_wd);
        }
        transaction.commit();
    }
}
