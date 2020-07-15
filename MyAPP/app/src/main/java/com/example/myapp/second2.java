package com.example.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class second2 extends AppCompatActivity {
private TextView test1;
private TextView test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        findView();
        getDeviceVal();
    }

    private void findView() {
        test1=findViewById(R.id.test1);
    }

    private void getDeviceVal() {
    new Thread(){
        @Override
        public void run() {
           try{
               JSONObject jsonobj= new JSONObject();
               jsonobj.put("testkey","dayin");
               String content=String.valueOf(jsonobj);
               String urlString="http://10.0.2.2:8080/AndroidMyServer/chenkDevice?itemName=device.leftSize";
               URL url = new URL(urlString);

               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               connection.setConnectTimeout(5000);
               connection.setRequestMethod("POST");
               connection.setDoOutput(true);
               connection.setRequestProperty("User-Agent", "Fiddler");
               connection.setRequestProperty("Content-Type", "application/json");
               connection.setRequestProperty("Charset", "UTF-8");
               OutputStream os = connection.getOutputStream();
               os.write(content.getBytes());
               os.close();
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }.start();


    }


}
