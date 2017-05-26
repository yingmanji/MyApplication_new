package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.example.a0_0.myapplication_new.model.DialogUtil;

public class Activity_DialogUtil extends Activity {
    Dialog dialog=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__dialog_util);
    }
    public void loading(View view)
    {
        dialog= DialogUtil.loadingDialog(this);
        if(dialog!=null&& !dialog.isShowing())
        {
            dialog.show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(dialog!=null&&dialog.isShowing())
        {
            dialog.dismiss();
        }
    }
}
