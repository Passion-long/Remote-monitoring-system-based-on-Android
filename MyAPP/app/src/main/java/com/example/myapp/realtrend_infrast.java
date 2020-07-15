package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class realtrend_infrast extends AppCompatActivity {

    private final int HIGH = 0;//高温下标
    private final int LOW = 1;// 低温线下标
    private  Handler handler = new Handler();
    private Button btn_1;
    private Button btn_2;
    private Button btn;
    //新建一个字符串集合，选择每次添加Entry时将当前时间添加进集合，然后设置X轴的值

    //    private List<ILineDataSet> lineDataSets=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtrend_infrast);
        btn=(Button)findViewById(R.id.history4);//历史趋势
        btn_1=(Button)findViewById(R.id.real_btn17);//选择设备
        btn_2=(Button)findViewById(R.id.real_btn18);//选择参数

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到btn演示界面
                Intent intent=new Intent(realtrend_infrast.this,historytrend.class);
                startActivity(intent);
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到btn演示界面
                Intent intent1=new Intent(realtrend_infrast.this,realtrend_chooseinf.class);
                startActivity(intent1);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到btn演示界面
                Intent intent=new Intent(realtrend_infrast.this,realtrend_choosecon.class);
                startActivity(intent);
            }
        });

        final LineChart mChart = (LineChart) findViewById(R.id.realchart3);
        initialChart(mChart);
        addLineDataSet(mChart);

        Runnable task = new Runnable() {
            public void run() {
                handler.postDelayed(this,1*1200);//设置循环时间，此处是1秒
                addEntry(mChart);
                //要执行的程序
            }
        };
        handler.post(task);//立即调用
    }
    private List<String> timeList=new ArrayList<>();//存储X轴时间
    // 初始化图表
    private void initialChart(LineChart mChart) {
        mChart.setDescription("时间");
        mChart.setNoDataTextDescription("暂时尚无数据");
        mChart.setTouchEnabled(true);// 可拖曳
        mChart.setDragEnabled(true);// 可缩放
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setPinchZoom(true);
        mChart.setBackgroundColor(0xfff5f5f5);// 设置图表的背景颜色
        Legend l = mChart.getLegend();// 图表的注解(只有当数据集存在时候才生效)
        // 可以修改图表注解部分的位置
        // l.setPosition(LegendPosition.LEFT_OF_CHART);
        l.setForm(LegendForm.LINE);// 线性，也可是圆
        l.setTextColor(Color.BLACK);// 颜色
        XAxis xl = mChart.getXAxis();// x坐标轴
        xl.setTextColor(0xff00897b);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);
        xl.setSpaceBetweenLabels(5); // 几个x坐标轴之间才绘制？
        xl.setEnabled(true);// 如果false，那么x坐标轴将不可见
        xl.setPosition(XAxisPosition.BOTTOM);    // 将X坐标轴放置在底部，默认是在顶部。
//        xl.setValueFormatter(new DefaultXAxisValueFormatter(){
//
//            public String getFormattedValue(float value, AxisBase axisBase) {
//                SimpleDateFormat df=new SimpleDateFormat("HH:mm:ss");
//                String s = timeList.get((int) (value%timeList.size()));
//                return s;
//            }
//        });

        // 图表左边的y坐标轴线
        YAxis leftAxis1 = mChart.getAxisLeft();
        leftAxis1.setTextColor(0xff37474f);
        leftAxis1.setAxisMaxValue(60f);// 最大值
        leftAxis1.setAxisMinValue(20f); // 最小值
        leftAxis1.setStartAtZero(false);// 不一定要从0开始
        leftAxis1.setDrawGridLines(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(false);// 不显示图表的右边y坐标轴线
    }

    // 为LineChart增加LineDataSet
    private void addLineDataSet(final LineChart mChart) {
        LineData data = new LineData();

        data.addDataSet(createHighLineDataSet());
//        data.addDataSet(createLowLineDataSet());
        // data.setValueTextColor(Color.WHITE); // 数据显示的颜色
        mChart.setData(data); // 先增加一个空的数据，随后往里面动态添加
    }

    // 同时为高温线和低温线添加进去一个坐标点
    private void addEntry(LineChart mChart) {
        LineData data = mChart.getData();
        data.addXValue("9:10:" +(data.getXValCount()) );


        // 增加高温
        LineDataSet highLineDataSet = data.getDataSetByIndex(HIGH);
        float fh = (float) ((Math.random()) * 10 + 40);

        Entry entryh = new Entry(fh, highLineDataSet.getEntryCount());
        data.addEntry(entryh, HIGH);

//        // 增加低温
//        LineDataSet lowLineDataSet = data.getDataSetByIndex(LOW);
//        float fl = (float) ((Math.random()) * 10+10);
//        Entry entryl = new Entry(fl, lowLineDataSet.getEntryCount());
//        data.addEntry(entryl, LOW);

        mChart.notifyDataSetChanged();
        mChart.setVisibleXRangeMaximum(9); // 当前统计图表中最多在x轴坐标线上显示的总量
        mChart.moveViewToX(data.getXValCount() - 9);
    }

    // 初始化数据集，添加一条高温统计折线
    private LineDataSet createHighLineDataSet() {

        LineDataSet set = new LineDataSet(null, "NDS轧制力");
        set.setAxisDependency(AxisDependency.LEFT);

        set.setColor(Color.RED);// 折线的颜色
        set.setCircleColor(Color.YELLOW);
        set.setLineWidth(1f);
        set.setCircleSize(5f);
        // set.setFillAlpha(128);
        set.setCircleColorHole(Color.BLUE);
        set.setHighLightColor(Color.GREEN);
        set.setValueTextColor(Color.RED);
        set.setValueTextSize(10f);
        set.setDrawCubic(true);
        set.setCubicIntensity(0.1f);
        set.setDrawValues(true);

        set.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex,
                                            ViewPortHandler viewPortHandler) {
                DecimalFormat decimalFormat = new DecimalFormat(".0kN");
                String s =  decimalFormat.format(value);
                return s;
            }
        });
        return set;
    }

    // 初始化数据集，添加一条低温统计折线
//    private LineDataSet createLowLineDataSet() {
//
//        LineDataSet set = new LineDataSet(null, "DS轧制力");
//        set.setAxisDependency(AxisDependency.LEFT);
//
//        set.setColor(ColorTemplate.getHoloBlue()); // 折线的颜色
//        set.setCircleColor(Color.BLUE);
//        set.setLineWidth(1f);
//        set.setCircleSize(5f);
//        // set.setFillAlpha(128);
//        // set.setFillColor(ColorTemplate.getHoloBlue());
//        set.setHighLightColor(Color.DKGRAY);
//        set.setValueTextColor(Color.BLACK);
//        set.setCircleColorHole(Color.RED);
//        set.setValueTextSize(10f);
//        set.setDrawValues(true);
//
//        set.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, Entry entry, int dataSetIndex,
//                                            ViewPortHandler viewPortHandler) {
//                DecimalFormat decimalFormat = new DecimalFormat(".0kN");
//                String s =decimalFormat.format(value);
//                return s;
//            }
//        });
//        return set;
//    }
}