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
public class Fragment_ChatTwo extends Fragment {
    private TextView tv2;

    public Fragment_ChatTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__chat_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle=getArguments();
        tv2=(TextView) view.findViewById(R.id.tv2);
        if(null!=bundle)
        {
            tv2.setText(bundle.getString("key_one","one"));
        }
    }
}
