package com.example.myapp;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

public class simulation extends AppCompatActivity implements View.OnClickListener{
    private boolean run=false;
    private final Handler handler=new Handler();
private VideoView vid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        findview();
        initVideoPath();
        run=true;
        vid.start();
        handler.postDelayed(task,20000);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                vid.pause();
                break;
            case MotionEvent.ACTION_UP:
                vid.start();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private final Runnable task=new Runnable() {
         @Override
         public void run() {
             if(run){
                 vid.start();
                 handler.postDelayed(this,20000);
             }
         }
     };
    private void findview() {
        vid=findViewById(R.id.video);
    }
    private void initVideoPath(){
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/"+ R.raw.video);//本地视频
        vid.setVideoURI(uri);
        /*Uri uri=Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");//网络视频
        videoView.setVideoURI(uri);*/
    }

    @Override
    public void onClick(View v) {

    }
}
