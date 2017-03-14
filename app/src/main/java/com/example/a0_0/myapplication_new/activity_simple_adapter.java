package com.example.a0_0.myapplication_new;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class activity_simple_adapter extends Activity {
    private static final String[]items1={"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private static final String[]items2={"北京市2","上海市2","广州市2","深圳市2","重庆市2","天津市2","武汉市2","西安市2","沈阳市2","长沙市2","珠海市2"
    ,"北京市","上海市","广州市","深圳市","重庆市","天津市","武汉市","西安市","沈阳市","长沙市","珠海市"};
    private static final int[]imgIds={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher
    ,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
    private TextView textView1;
    private TextView textView2;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);



        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        List<Map<String,String>>data=new ArrayList<>();

        for(int i=0;i<items2.length;i++){
            Map<String,String> map=new HashMap< >();
            map.put("img",String.valueOf(imgIds[i]));
            map.put("tv1",items2[i]);
            map.put("tv2",items2[i]);
            data.add(map);
        }
        listView=(ListView)findViewById(R.id.listView);
        MySimpleAdapter simpleAdapter=new MySimpleAdapter(this,data,R.layout.item,new String[]{"img","tv1","tv2"},
                new int[]{R.id.img,R.id.textView1,R.id.textView2});
        listView.setAdapter(simpleAdapter);
        /*for(int i=0;i<simpleAdapter.getCount();i++)
        {
            View view=listView.getChildAt(i);
            TextView textView=(TextView) simpleAdapter.getView(i,view,listView).findViewById(R.id.textView1);//从视图中获得texView，赋予三个参数，第一个是i，第二个view原来视图即item,第三个是listView，外容器即activity的布局里的listView
            textView.setBackgroundColor(Color.BLUE);
        }
        simpleAdapter.notifyDataSetChanged();*/
    }
    class MySimpleAdapter extends SimpleAdapter{
        private Context mContext;
        private List<Map<String,String>> mlist;
        private int mResource;
        private String[]mFrom;
        private int[]mTo;

        /**
         * Constructor
         *
         * @param context  The context where the View associated with this SimpleAdapter is running
         * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
         *                 Maps contain the data for each row, and should include all the entries specified in
         *                 "from"
         * @param resource Resource identifier of a view layout that defines the views for this list
         *                 item. The layout file should include at least those named views defined in "to"
         * @param from     A list of column names that will be added to the Map associated with each
         *                 item.
         * @param to       The views that should display column in the "from" parameter. These should all be
         *                 TextViews. The first N views in this list are given the values of the first N columns
         */
        public MySimpleAdapter(Context context,List<Map<String,String>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            mContext=context;
            mlist=data;
            mResource=resource;
            mFrom=from;
            mTo=to;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //第一个实现方法通过动态类LayoutInflater
            /*LayoutInflater inflater=LayoutInflater.from(mContext);//动态定义inflater，上下文参数选mContext
            convertView=inflater.inflate(mResource,parent,false);//把布局Item放入convertview中
            ImageView imageView=(ImageView)convertView.findViewById(mTo[0]);
            TextView tv1=(TextView)convertView.findViewById(mTo[1]);
            TextView tv2=(TextView)convertView.findViewById(mTo[2]);
            imageView.setImageResource(R.mipmap.ic_launcher);
            tv1.setText(mlist.get(position).get(mFrom[1]));
            tv2.setText(mlist.get(position).get(mFrom[2]));
            if(position%3==0)
            {
                tv1.setBackgroundColor(Color.BLUE);
            }
            return convertView;*/
            //直接用getView,再用row替换convertView,其实与法一类似
/*            View row=super.getView(position,convertView,parent);//row相当于item即convertView
            ImageView imageView=(ImageView)row.findViewById(mTo[0]);
            TextView tv1=(TextView)row.findViewById(mTo[1]);
            TextView tv2=(TextView)row.findViewById(mTo[2]);
            imageView.setImageResource(R.mipmap.ic_launcher);
            tv1.setText(mlist.get(position).get(mFrom[1]));
            tv2.setText(mlist.get(position).get(mFrom[2]));
            if(position%3==0)
            {
                tv1.setBackgroundColor(Color.BLUE);
            }
            return row;*/
            View row=super.getView(position,convertView,parent);
            ViewHoder viewHoder=(ViewHoder) row.getTag();//不用每行都创建viewHoder,只要给一个标记给第一行
            if(null==viewHoder)//据说这种把null放前面view..放后面的写法可以提高性能,即常量写去前面，变量写后面,此处表示如果没有标记则创建viewHoder
            {
                viewHoder=new ViewHoder(row);
                row.setTag(viewHoder);//给行赋予标记,用viewHoder作标记,使得下次再遇到该行时不用再创建一次,可以将图片的id作为tag传入,后面再比对
                viewHoder.img.setImageResource(R.mipmap.ic_launcher);
                viewHoder.tv1.setText(mlist.get(position).get(mFrom[1]));
                viewHoder.tv2.setText(mlist.get(position).get(mFrom[2]));
            }
            if(position%3==0)
            {
                viewHoder.tv1.setBackgroundColor(Color.BLUE);
            }
            else//使用了复用提高了性能,但是会出现问题,当快速滑动时,会变混乱可通过比对赋予的图片id来保证不会混乱
            {
                viewHoder.tv1.setBackgroundColor(Color.WHITE);
            }
            return row;
        }
    }
    class ViewHoder{//控制视图的类,自定义的名字,改进之处：但需要使用多个item的时候,就不需要写多次findViewById()
        ImageView img=null;
        TextView tv1=null;
        TextView tv2=null;

        public ViewHoder(View view) {
            img=(ImageView)view.findViewById(R.id.img);
            tv1=(TextView)view.findViewById(R.id.textView1);
            tv2=(TextView)view.findViewById(R.id.textView2);
        }
    }
}
