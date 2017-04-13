package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.a0_0.myapplication_new.fragments.DetailFragment;
import com.example.a0_0.myapplication_new.fragments.MasterFragment;

public class Activity_dual extends Activity {//通过实现创建的接口OnMasterSelectedListener来实现Fragment到Activity到Fragment之间的通信
    private boolean dualPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual);
        MasterFragment master=null;
        FrameLayout frameLayout=(FrameLayout) findViewById(R.id.frameLayout);
        if(frameLayout!=null)
        {
            dualPane=false;
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            master=(MasterFragment) getFragmentManager().findFragmentByTag("MASTER");
            if(master==null)
            {
                master=new MasterFragment();
                transaction.add(R.id.frameLayout,master,"MASTER");
            }
            transaction.commit();
        }
        else
        {
            dualPane=true;
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            master=(MasterFragment) getFragmentManager().findFragmentById(R.id.frameLayout_master);
            if(master==null)
            {
                master=new MasterFragment();
                transaction.add(R.id.frameLayout_master,master);
            }
            DetailFragment detail=(DetailFragment) getFragmentManager().findFragmentById(R.id.frameLayout_detail);
            if(detail==null)
            {
                detail=new DetailFragment();
                transaction.add(R.id.frameLayout_detail,detail);
            }
            transaction.commit();
        }
        master.setOnMasterSelectedListener(new MasterFragment.OnMasterSelectedListener() {
            @Override
            public void onItemSelected(String cityName) {
                sendCityName(cityName);
            }
        });
    }

    private void sendCityName(String cityName) {
        DetailFragment detail;
        if(dualPane)
        {
            detail=(DetailFragment) getFragmentManager().findFragmentById(R.id.frameLayout_detail);
            detail.showSelectedCityName(cityName);
        }else
        {
            detail=new DetailFragment();
            Bundle bundle=new Bundle();
            bundle.putString(DetailFragment.KEY_CITY_NAME,cityName);
            detail.setArguments(bundle);
            FragmentTransaction transaction=getFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout,detail);
            transaction.addToBackStack(null);//将被替换的Fragment添加到回退栈
            transaction.commit();
        }
    }
}
