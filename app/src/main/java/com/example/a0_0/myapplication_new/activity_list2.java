package com.example.a0_0.myapplication_new;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class activity_list2 extends ListActivity {
    private static final String[]items={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private TextView textView2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);
        //textView必须放在setContentView之后
        textView2=(TextView)findViewById(R.id.textView2);
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));//注意与继承普通Activity不一样，不用找到list,有自带的setListAdapter方法
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        textView2.setText(items[position]);
    }
}
