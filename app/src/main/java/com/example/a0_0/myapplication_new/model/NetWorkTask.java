package com.example.a0_0.myapplication_new.model;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Administrator on 2017/4/20.
 */

public class NetWorkTask extends AsyncTask<String ,Integer,String> {
    private TextView tv_data;
    private ProgressBar pb_load;
    public NetWorkTask(TextView tv_data,ProgressBar pb_load)
    {
        this.tv_data=tv_data;
        this.pb_load=pb_load;
    }
    @Override
    protected String doInBackground(String... params) {
       /* try{
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
        }*/
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream=connection.getInputStream();
            int total=connection.getContentLength();
            int downloadSize=0;
            byte[] buf=new byte[1];
            int in;
            StringBuffer result=new StringBuffer();
            while((in=inputStream.read(buf))!=-1)
            {
                for(int i=1;i<1000000000;i++)
                {
                    downloadSize=downloadSize+in;//计算文件已下载大小
                    int progress=(int)((float)downloadSize/total*100);//计算已下载百分数
                    publishProgress(progress);//显示已下载百分数
                    result.append(new String(buf, 0, in));//将下载的数据添加到result中
                }
            }
            return result.toString();
        }

        catch (Exception e)
        {
            return "error";
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pb_load.setProgress(values[0]);
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
