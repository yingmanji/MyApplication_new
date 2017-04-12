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
public class DetailFragment extends Fragment {
    public static final String KEY_CITY_NAME="KEY_CITY_NAME";

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null&&bundle.containsKey(KEY_CITY_NAME))
        {
            showSelectedCityName(bundle.getString(KEY_CITY_NAME,""));
        }
    }

    public void showSelectedCityName(String cityName) {
        ((TextView)getView().findViewById(R.id.tv)).setText(cityName);
    }
}
