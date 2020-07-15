package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity  implements View.OnClickListener{
    //--------------
    private Handler handler1 = new Handler();//定义handler1
    private Handler handler2 = new Handler();//定义handler2
    private MyDialog1 myDialog;
    //--------------
    private Banner mbanner;
    private ImageButton btnMenu;
    private ImageButton a1;
    private ImageButton b1;
    private ImageButton c1;
    private ImageButton d1;
    private ImageButton e1;
    private ImageButton f1;
    private ImageButton g1;
    private ImageButton h1;
    private ImageButton i1;
    private ImageButton j1;
    private ImageButton k1;
    private ImageButton l1;
    private Button m1;
    private TextView t1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        setContentView(R.layout.alarm1_main);
//        initView();//轮播图片
        t1 = findViewById(R.id.t1);
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                /**
//                 *要执行的操作
//                 */
//                t1.setTextColor(Color.argb(127, 255, 0, 0));
//            }
//        };
//        Timer timer = new Timer();
//        timer.schedule(task, 3000);
        Handler mHandler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t1.setTextColor(Color.argb(127, 255, 0, 0));
            }
        };
        mHandler.postDelayed(r, 5000);//延时
        findView();
        setListener();
        //-----------------------
        //-----------------------
    }
    //-------------------------------




    //----------------------------------
    private void setListener() {
//        btnMenu.setOnClickListener(this);
        a1.setOnClickListener(this);
        b1.setOnClickListener(this);
        c1.setOnClickListener(this);
        d1.setOnClickListener(this);
        e1.setOnClickListener(this);
        f1.setOnClickListener(this);
        g1.setOnClickListener(this);
        h1.setOnClickListener(this);
        i1.setOnClickListener(this);
        j1.setOnClickListener(this);
        k1.setOnClickListener(this);
        l1.setOnClickListener(this);
        m1.setOnClickListener(this);
       // btnMenu.setOnClickListener(this);


    }

    private void findView() {
//        btnMenu=findViewById(R.id.btnMenu);
        a1=findViewById(R.id.a1);
        b1=findViewById(R.id.b1);
        f1=findViewById(R.id.f1);
        c1=findViewById(R.id.c1);
        e1=findViewById(R.id.e1);
        d1=findViewById(R.id.d1);
        g1=findViewById(R.id.g1);
        h1=findViewById(R.id.h1);
        i1=findViewById(R.id.i1);
        j1=findViewById(R.id.j1);
        k1=findViewById(R.id.k1);
        l1=findViewById(R.id.l1);
        m1=findViewById(R.id.m1);

    }
    //----------------------------

    //----------------------------

//    private void initView() {
//        try {
//            mbanner=findViewById(R.id.mbanner);
//            int[] inageResouceID = new int[]{R.drawable.lunbo1,R.drawable.cheat,R.drawable.zhapingsecond3, R.drawable.zhasecond1};
//            List<Integer> imageList = new ArrayList<>();
//            for (int i = 0; i < inageResouceID.length; i++) {
//                imageList.add(inageResouceID[i]);
//                mbanner.setImageLoader(new ImageLoader() {
//                    @Override
//                    public void displayImage(Context context, Object path, ImageView imageView) {
//                        Glide.with(Main2Activity.this).load(path).into(imageView);
//                    }
//                });
//                mbanner.setDelayTime(2000);//轮播时间
//                mbanner.setImages(imageList);//轮播资源
//                mbanner.start();
//            }
//        }catch (NullPointerException e){}
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.btnMenu:
//               //FragmentManager fragmentmanager=getSupportFragmentManager();
//                leftmenu left=new leftmenu();
//                left.setCancelable(true);
//                left.show(getFragmentManager(),"leftmenu");
//Toast.makeText(Main2Activity.this,"ce菜单",Toast.LENGTH_SHORT).show();
//                break;
            case R.id.a1:Toast.makeText(Main2Activity.this, "工艺流程", Toast.LENGTH_SHORT).show();
                Intent a1=new Intent(Main2Activity.this,simulation.class);
                startActivity(a1);
                break;
            case R.id.b1:
                Toast.makeText(Main2Activity.this, "铸轧机", Toast.LENGTH_SHORT).show();
                Intent b1= new Intent(Main2Activity.this, second2.class);
                startActivity(b1);
                break;
            case R.id.c1:Toast.makeText(Main2Activity.this, "平整机", Toast.LENGTH_SHORT).show();
            Intent c1=new Intent(Main2Activity.this,second3.class);
            startActivity(c1);
                break;
            case R.id.d1:
                Toast.makeText(Main2Activity.this, "温轧机", Toast.LENGTH_SHORT).show();
                Intent d1= new Intent(Main2Activity.this, second1.class);
                startActivity(d1);
                break;
            case R.id.e1:Toast.makeText(Main2Activity.this, "参数列表", Toast.LENGTH_SHORT).show();
                Intent e1=new Intent(Main2Activity.this,parameterlists.class);
                startActivity(e1);
                break;
            case R.id.f1:Toast.makeText(Main2Activity.this, "趋势曲线", Toast.LENGTH_SHORT).show();
                Intent f1= new Intent(Main2Activity.this, trend.class);
                startActivity(f1);
                break;
            case R.id.g1:Toast.makeText(Main2Activity.this, "现场监控", Toast.LENGTH_SHORT).show();
            Intent g1=new Intent(Main2Activity.this,monitor.class);
            startActivity(g1);
                break;
            case R.id.h1:Toast.makeText(Main2Activity.this, "报警", Toast.LENGTH_SHORT).show();
                Intent h1= new Intent(Main2Activity.this, alarm2.class);
                startActivity(h1);
                break;
            case R.id.i1:Toast.makeText(Main2Activity.this, "生产预测", Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(Main2Activity.this,productionforecast.class);
                startActivity(i1);
                break;
            case R.id.j1:Toast.makeText(Main2Activity.this, "AR", Toast.LENGTH_SHORT).show();
                Intent j1=new Intent(Main2Activity.this,AR.class);
                startActivity(j1);
                break;
            case R.id.k1:Toast.makeText(Main2Activity.this, "人员管理", Toast.LENGTH_SHORT).show();
                Intent k1=new Intent(Main2Activity.this,userMange.class);
                startActivity(k1);
                break;
            case R.id.l1:Toast.makeText(Main2Activity.this, "设备总貌", Toast.LENGTH_SHORT).show();
                Intent l1=new Intent(Main2Activity.this,processIntro.class);
                startActivity(l1);
                break;
            case R.id.m1:Toast.makeText(Main2Activity.this, "报警", Toast.LENGTH_SHORT).show();
                Intent m1= new Intent(Main2Activity.this, alarm2.class);
                startActivity(m1);
                break;
        }
    }
}

