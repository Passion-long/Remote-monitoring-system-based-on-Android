package com.example.myapp;

import android.graphics.drawable.Drawable;
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

public class second1 extends AppCompatActivity {
    private boolean run1 = false;
    private TextView leftSize;
    private TextView rightSize;
    private TextView ndsKN;
    private TextView ndsMM;
    private TextView gdMM;
    private TextView dsMM;
    private  TextView dsKN;
    private  int dskn;
    private  boolean isStop;
    private final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second1);
        run1 = true;
        isStop=true;
        findview();
       handler.postDelayed(task, 1200);
    }


    private final Runnable task = new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                if (run1&&isStop) {
                    String leftsize=getleftSize();
                    new second1.getLeftSize().execute(leftsize);

                    String rightSize=getrightSize();
                    new second1.getRightSize().execute(rightSize);

                    String ndsMM= getndsMM();
                    new second1.getndsMM().execute(ndsMM);

                    String ndsKN=getndsKN();
                    new second1.getndsKN().execute(ndsKN);

                    String gdMM=getgdMM();
                    new second1.getgdMM().execute(gdMM);

                    String dsMM=getdsMM();
                    new second1.getdsMM().execute(dsMM);

                    String dsKN=getdsKN();
                    new second1.getdsKN().execute(dsKN);

                    handler.postDelayed(this, 1200);
                }
            }
        };
    //http://neuq.top/chenkDevice?itemName=2"
    //本地http://10.0.2.2:8080/AndroidMyServer/chenkDevice?itemName=device.leftSize
    String u="http://neuq.top/chenkDevice?itemName=";
   // String u1="http://10.0.2.2:8080/AndroidMyServer/chenkDevice?itemName=";
    private String getleftSize() {
       // String uu=u+"";
//        return u+"device.leftSize";
       return "http://neuq.top/chenkDevice?itemName=2";

    }private String getndsMM() {
        return u+"device.ndsMM";
    }private String getndsKN() {
        return u+"device.ndsKN";
    }private String getgdMM() {
        return u+"device.gdMM";
    }private String getdsMM() {
        return u+"device.dsMM";
    }private String getdsKN() {
        return u+"device.dsKN";
    }private String getrightSize() {
        return u+"device.rightSize";
    }
    private void findview() {
        leftSize=(TextView)findViewById(R.id.leftSize);
        rightSize=(TextView)findViewById(R.id.rightSize);
        ndsMM=(TextView)findViewById(R.id.ndsMM);
        ndsKN=(TextView)findViewById(R.id.ndsKN);
        dsMM=(TextView)findViewById(R.id.dsMM);
        dsKN=(TextView)findViewById(R.id.dsKN);
        gdMM=(TextView)findViewById(R.id.gdMM);
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
                reader.close();/////////////////////////////////
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
    class  getLeftSize extends AsyncTask<String,Integer,String> {
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
           // Toast.makeText(second1.this,"gua不管了输出ntade"+result,Toast.LENGTH_LONG).show();
            leftSize.setText(result);
        }
    }
    class  getRightSize extends AsyncTask<String,Integer,String> {
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
            rightSize.setText(result);//
        }
    }
    class  getndsMM extends AsyncTask<String,Integer,String> {
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
            ndsMM.setText(result);//
        }
    }
    class  getndsKN extends AsyncTask<String,Integer,String> {
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
            ndsKN.setText(result);//
        }
    }
    class  getgdMM extends AsyncTask<String,Integer,String> {
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
            gdMM.setText(result);//
        }
    }
    class  getdsMM extends AsyncTask<String,Integer,String> {
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
            dsMM.setText(result);//
        }
    }
    class  getdsKN extends AsyncTask<String,Integer,String> {
        @Override//在后台之前（主线程）
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override//后台线程中
        protected String doInBackground(String[] params) {
            String result = requestData(params[0]);
            return result;
        }

        @Override//线程处理完，返回主线程中
        protected void onPostExecute(String result) {
           // try {
            //int a=Integer.parseInt(result);
                super.onPostExecute(result);
                //int a = Integer.parseInt(result);
           // int a=Integer.parseInt(result);
            //dskn=Integer.valueOf(result).intValue();
           // if(a<90){
                dsKN.setTextColor(0xffff0000);
           // }
                dsKN.setText(result);
                /*dsKN.setBackground(Drawable.createFromPath("#ff0000"));*/
               //}
            /*} catch (NumberFormatException e) {
                e.printStackTrace();
            }*/
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isStop=false;
    }
}