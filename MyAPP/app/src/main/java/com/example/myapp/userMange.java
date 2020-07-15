package com.example.myapp;

import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class userMange extends AppCompatActivity {
private WebView view1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mange);
        /* fiendView(); */

        view1=findViewById(R.id.userView);
//        view1.loadUrl("http://www.neuq.top/mange/login.jsp");
        view1.loadUrl("http://m.neuq.top/AllLogin/mangeLogin?logname=2&password=2");
//http://192.168.43.134:8080/AndroidMyServer/queryList局域网里使用
       // view1.loadUrl("http://aaa.neuq.top/mange/login.jsp");
//        WebView view=findViewById(R.id.userView);
        view1.getSettings().setJavaScriptEnabled(true);


       view1.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                //返回true则在本容器中跳转，false则打开其他浏览器加载界面
                return true;
            }

           @Override
           public void onPageStarted(WebView view, String url, Bitmap favicon) {
               super.onPageStarted(view, url, favicon);
               Toast.makeText(userMange.this,"页面加载中...",Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onPageFinished(WebView view, String url) {
               super.onPageFinished(view, url);
               Toast.makeText(userMange.this,"加载完成",Toast.LENGTH_SHORT).show();
            }
       });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(view1.canGoBack()){
                 view1.goBack();
                return true;
                }else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
//    private void fiendView() {
//
//    }
}
