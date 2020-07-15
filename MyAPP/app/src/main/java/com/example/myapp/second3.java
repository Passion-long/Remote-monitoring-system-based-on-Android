package com.example.myapp;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class second3 extends AppCompatActivity {
    private TextView nds;
    private TextView ds;
    private  boolean run,isStop;
    private final Handler handler= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);
        run=true;
        isStop=true;
        findview();
        handler.postDelayed(task,1200);
    }
    private  final  Runnable task=new Runnable() {
        @Override
        public void run() {
            if (run&&isStop){
                String u="http://neuq.top/chenkDevice?itemName=";
                //http://10.0.2.2:8080/AndroidMyServer/chenkDevice?itemName=
                    String url=u+"device.ndsKN";
                    new second3.pingNDS().execute(url);
                    String dsURL=u+"device.dsMM";
                    new second3.pingDS().execute(dsURL);
                handler.postDelayed(this,1200);
            }
        }
    };
    private void findview() {
        nds=findViewById(R.id.pingnds);
        ds=findViewById(R.id.pingds);
    }
    private String requestData(String urlString) {
        try{try{try{
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(30000);
                connection.setRequestMethod("GET");
                connection.connect();
                int responseCode = connection.getResponseCode();//获取到的状态码
                String resMsg = connection.getResponseMessage();//返回的信息
                InputStream inputStream = connection.getInputStream();//返回的流
                // Reader read=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String result = reader.readLine();
                inputStream.close();
                reader.close();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } }catch (IOException e) {
            e.printStackTrace();
        } }
        catch (NullPointerException e) {
        }}catch(RuntimeException e){
        }
        return null;
    }
    class  pingNDS extends AsyncTask<String,Integer,String> {
        @Override//在后台之前（主线程）
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override//后台线程中
        protected String doInBackground(String[] params) {
            String result=requestData(params[0]);
            return result;
        }
        @Override//线程处理完，返回主线程中
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            nds.setText(result);
            //Toast.makeText(second1.this,"gua不管了输出ntade"+result,Toast.LENGTH_LONG).show();
            //leftSize.setText(result);
        }
    } class  pingDS extends AsyncTask<String,Integer,String> {
        @Override//在后台之前（主线程）
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override//后台线程中
        protected String doInBackground(String[] params) {
            String result=requestData(params[0]);
            return result;
        }
        @Override//线程处理完，返回主线程中
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //Toast.makeText(second1.this,"gua不管了输出ntade"+result,Toast.LENGTH_LONG).show();
            //leftSize.setText(result);
            ds.setText(result);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStop=false;
    }
}
