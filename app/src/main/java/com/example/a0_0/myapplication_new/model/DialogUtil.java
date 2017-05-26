package com.example.a0_0.myapplication_new.model;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.example.a0_0.myapplication_new.R;

/**
 * Created by Administrator on 2017/5/26.
 */

public class DialogUtil {
    public static Dialog loadingDialog(Context context)
    {
        Dialog dialog=new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//弹出windows窗口(无标题)
        dialog.setContentView(R.layout.loading_dialog_view);
        dialog.setCancelable(false);//设置为弹出dialog不可点击其他地方取消
        return dialog;
    }
}
