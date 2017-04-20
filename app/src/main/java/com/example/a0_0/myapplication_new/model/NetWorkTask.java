package com.example.a0_0.myapplication_new.model;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Administrator on 2017/4/20.
 */

public class NetWorkTask extends AsyncTask<String ,Integer,String> {
    private TextView tv_data;
    public NetWorkTask(TextView tv_data)
    {
        this.tv_data=tv_data;
    }
    @Override
    protected String doInBackground(String... params) {
        try{
            URL url=new URL("https://www.baidu.com");
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            InputStreamReader inputStreamReader=new InputStreamReader(connection.getInputStream());
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String result="";
            String line="";
            while((line=reader.readLine())!=null)
            {
                result+=line;
            }
            reader.close();
            return  result;
        }
        catch (Exception e)
        {
            return "error";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s!=null)
        {
            tv_data.setText(s);
        }
    }
}
