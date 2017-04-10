package com.example.a0_0.myapplication_new.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a0_0.myapplication_new.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_ChatOne extends Fragment {
    private TextView tv1;

    public Fragment_ChatOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__chat_one, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle=getArguments();
        tv1=(TextView) view.findViewById(R.id.tv1);
        if(null!=bundle)
        {
            tv1.setText(bundle.getString("key_one","one"));
        }
    }
}
