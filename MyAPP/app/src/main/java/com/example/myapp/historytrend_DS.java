package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

//---------------------------------

public class historytrend_DS extends AppCompatActivity {
    private final int HIGH = 0;//高温下标
    private final int LOW = 1;// 低温线下标
    private Button btn;//实时趋势
    private Button btn1;//跳转参数
    private Button btn2;//实时趋势

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historytrend__ds);

        btn=(Button)findViewById(R.id.real6);//
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面n
                Intent intent=new Intent(historytrend_DS.this,trend.class);
                startActivity(intent);
            }
        });
        btn1=(Button)findViewById(R.id.his_btn12);//设备选择
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到TextView演示界面n
                Intent intent=new Intent(historytrend_DS.this,historytrend_choose.class);
                startActivity(intent);

            }
        });
//        btn2=(Button)findViewById(R.id.real5);//参数选择
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到TextView演示界面n
//                Intent intent=new Intent(historytrend.this,trend.class);
//                startActivity(intent);
//            }
//        });

        LineChart lineChart = (LineChart) findViewById(R.id.hischart1);
        lineChart.setDescription("时间");
        lineChart.setData(getLineData(36, 100));
        lineChart.setTouchEnabled(true); // 设置是否可以触摸
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
//        //设置动画
//        lineChart.animateX(2500); // 立即执行的动画,x轴
//        lineChart.animateY(2500); // 立即执行的动画,x轴
//        lineChart.invalidate();
        Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        // modify the legend ...
        // mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
//        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
//        mLegend.setFormSize(6f);// 字体
//        mLegend.setTextColor(Color.BLACK);// 颜色
        Legend l = lineChart.getLegend();// 图表的注解(只有当数据集存在时候才生效)
        // 可以修改图表注解部分的位置
        // l.setPosition(LegendPosition.LEFT_OF_CHART);
        l.setForm(Legend.LegendForm.LINE);// 线性，也可是圆
        l.setTextColor(Color.BLACK);// 颜色
        XAxis xl = lineChart.getXAxis();// x坐标轴
        xl.setTextColor(0xff00897b);
        xl.setDrawGridLines(false);
        xl.setAvoidFirstLastClipping(true);
        xl.setSpaceBetweenLabels(5); // 几个x坐标轴之间才绘制？
        xl.setEnabled(true);// 如果false，那么x坐标轴将不可见
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);    // 将X坐标轴放置在底部，默认是在顶部。

        // 图表左边的y坐标轴线
        YAxis leftAxis1 = lineChart.getAxisLeft();
        leftAxis1.setTextColor(0xff37474f);
        leftAxis1.setAxisMaxValue(20f);// 最大值
        leftAxis1.setAxisMinValue(0f); // 最小值
        leftAxis1.setStartAtZero(false);// 不一定要从0开始
        leftAxis1.setDrawGridLines(true);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);// 不显示图表的右边y坐标轴线
    }

    private LineData getLineData(int i, int i1) {
        final int DATA_COUNT = 10;
        //   LineDataSet dataSet1 = new LineDataSet(getChartData1(DATA_COUNT, 1), "DS辊缝零位");
        LineDataSet dataSet2 = new LineDataSet(getChartData2(DATA_COUNT, 2), "钢带厚度");

//        dataSet1.setColor(Color.BLUE);
        dataSet2.setColor(Color.BLACK);
        dataSet2.setValueTextColor(Color.BLACK);
        dataSet2.setValueTextSize(10f);

        List<LineDataSet> dataSets = new ArrayList<>();
//        dataSets.add(dataSet1);
        dataSets.add(dataSet2);
        LineData data = new LineData(getLabels(DATA_COUNT), dataSets);
        return data;// 返回LineData类型数据，该类型由标识X轴单位 List<String>的 集合和一个标识折线数据的List<ILineDataSet>组成
    }

    //    private List<Entry> getChartData1(int count, int ratio) {
//        List<Entry> chartData = new ArrayList<>();
//        chartData.add( new Entry((float) 5.0, 0));
//        chartData.add(new Entry((float) 5.0, 1));
//        chartData.add(new Entry((float) 5.0, 2));
//        chartData.add(new Entry((float) 5.0, 3));
//        chartData.add(new Entry((float) 5.0, 4));
//        chartData.add(new Entry((float) 5.0, 5));
//        chartData.add(new Entry((float) 5.0, 6));
//        chartData.add(new Entry((float) 5.0, 7));
//        chartData.add(new Entry((float) 5.0, 8));
//        chartData.add(new Entry((float) 5.0, 9));
////            for (int i = 0; i < count; i++) {
////                chartData.add(new Entry(i * 2 * ratio, i));
////        }
//        return chartData;
//    }
    private List<Entry> getChartData2(int count, int ratio) {
        List<Entry> chartData = new ArrayList<>();
        chartData.add( new Entry((float) 5.06, 0));
        chartData.add(new Entry((float) 5.13, 1));
        chartData.add(new Entry((float) 5.00, 2));
        chartData.add(new Entry((float) 4.95, 3));
        chartData.add(new Entry((float) 5.03, 4));
        chartData.add(new Entry((float) 4.98, 5));
        chartData.add(new Entry((float) 5.04, 6));
        chartData.add(new Entry((float) 4.99, 7));
        chartData.add(new Entry((float) 5.03, 8));
        chartData.add(new Entry((float) 4.92, 9));
        return chartData;
    }
    //利用循环生成了(0,0) (2,1) (4,2) (6,3) (8,4)
    //(0,0) (4,1) (8,2) (12,3) (16,4) 这两组折线坐标 组成List<Entry>返回

    private List<String> getLabels(int count) {
        List<String> chartLabels = new ArrayList<>();

        for (int i = 1; i < 11; i++) {
            chartLabels.add("9:12:3" + i);
        }
        return chartLabels; }//生成横坐标的单位显示，(x0 x1 x2 x3 x4)这样的List<String>集合返回

}