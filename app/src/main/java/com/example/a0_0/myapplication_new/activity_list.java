package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_list extends Activity {
    TextView textView2;
    ListView listView;
    String[] items={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        textView2=(TextView)findViewById(R.id.textView2);
        listView=(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,items);
        listView.setAdapter(arrayAdapter);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //textView2.setText(items[position]);
                //textView2.setText(((TextView)listView.getChildAt(position)).getText());
                textView2.setText(((TextView)view).getText());
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(activity_list.this,items[position],Toast.LENGTH_LONG).show();
                return false;
            }
        });
        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                 Toast.makeText(activity_list.this,"down",Toast.LENGTH_LONG).show();
                else if(event.getAction()==MotionEvent.ACTION_UP)
                    Toast.makeText(activity_list.this,"up",Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
