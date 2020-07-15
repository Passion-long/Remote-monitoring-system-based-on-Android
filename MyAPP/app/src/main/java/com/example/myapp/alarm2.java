package com.example.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class alarm2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_main2);
        ListView lv=  findViewById(R.id.lv_main);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map =new HashMap<String, Object>();
        map.put("title","  序号                 时间                     设备名称             类别                  具体值");
        list.add(map);
       SimpleAdapter adapter = new SimpleAdapter(
               this,
               list,
               R.layout.bjitem,
               new String[]{"title"},
                new  int[]{R.id.tv_title1}
       );
        lv.setAdapter(adapter);
    }
}
