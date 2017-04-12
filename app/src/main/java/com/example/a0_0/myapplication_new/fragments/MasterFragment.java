package com.example.a0_0.myapplication_new.fragments;


import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.a0_0.myapplication_new.R;

/**
 * A simple {@link ListFragment} subclass.
 */
public class MasterFragment extends ListFragment {
    private OnMasterSelectedListener listener=null;

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] cityArray={"北京市","上海市","广州市","深圳市"};
        ListAdapter adapter=
                new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,cityArray);
        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener!=null){
                    listener.onItemSelected(((TextView)view).getText().toString());
                }
            }
        });
    }
    public void setOnMasterSelectedListener(OnMasterSelectedListener listener   )
    {
        this.listener=listener;
    }
    public interface OnMasterSelectedListener
    {
        void onItemSelected(String cityName);
    }
}
