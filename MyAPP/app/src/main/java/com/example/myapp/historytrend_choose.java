package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class historytrend_choose extends AppCompatActivity {
    private Button btn;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historytrend_choose);
        btn = (Button) findViewById(R.id.his_btn00);//返回trend
        btn_1 = (Button) findViewById(R.id.his_btn4);//NDS轧制力
        btn_2 = (Button) findViewById(R.id.his_btn5);//NDS轧制厚度
//        btn_3 = (Button) findViewById(R.id.real_btn11);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到btn演示界面
                Intent intent = new Intent(historytrend_choose.this, historytrend.class);
                startActivity(intent);
            }
        });
        //跳转回原页面温轧机NDS轧制力
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到btn演示界面
                Intent intent = new Intent(historytrend_choose.this, historytrend.class);
                startActivity(intent);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到btn演示界面
                Intent intent = new Intent(historytrend_choose.this, historytrend_DS.class);
                startActivity(intent);
            }
        });

//        //温轧机DS轧制力
//        btn_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到btn演示界面
//                Intent intent = new Intent(choose_con.this, contrast.class);
//                startActivity(intent);
//            }
//        });
//
    }
}
