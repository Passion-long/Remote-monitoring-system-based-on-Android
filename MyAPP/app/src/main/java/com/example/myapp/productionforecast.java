package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

public class productionforecast extends AppCompatActivity {
    private final int HIGH = 0;//高温下标
    private final int LOW = 1;// 低温线下标
//    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productionforecast);
//        btn=(Button)findViewById(R.id.production);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //跳转到TextView演示界面n
//                Intent intent=new Intent(productionforecast.this,second1change.class);
//                startActivity(intent);
//            }
//        });

        LineChart lineChart = (LineChart) findViewById(R.id.production);
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
//        xl.setValueFormatter(new XAxisValueFormatter() {
//            @Override
//            public String getXValue(String original, int index, ViewPortHandler viewPortHandler) {
//                return null;
//            }
//        });

        // 图表左边的y坐标轴线
        YAxis leftAxis1 = lineChart.getAxisLeft();
        leftAxis1.setTextColor(0xff37474f);
        leftAxis1.setAxisMaxValue(35f);// 最大值
        leftAxis1.setAxisMinValue(10f); // 最小值
        leftAxis1.setStartAtZero(false);// 不一定要从0开始
        leftAxis1.setDrawGridLines(true);

        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);// 不显示图表的右边y坐标轴线
    }

    private LineData getLineData(int i, int i1) {
        final int DATA_COUNT = 10;
        LineDataSet dataSet1 = new LineDataSet(getChartData1(DATA_COUNT, 1), "透气性指数实际值");
        LineDataSet dataSet2 = new LineDataSet(getChartData2(DATA_COUNT, 2), "透气性指数预测值");

        dataSet1.setColor(Color.BLUE);
        dataSet1.setValueTextColor(Color.BLUE);
        dataSet1.setValueTextSize(10f);
        dataSet1.setDrawCubic(true);
        dataSet1.setCubicIntensity(0.1f);
        dataSet2.setColor(Color.RED);
        dataSet2.setValueTextColor(Color.RED);
        dataSet2.setValueTextSize(10f);
        dataSet2.setDrawCubic(true);
        dataSet2.setCubicIntensity(0.1f);

        List<LineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet1);
        dataSets.add(dataSet2);
        LineData data = new LineData(getLabels(DATA_COUNT), dataSets);
        return data;// 返回LineData类型数据，该类型由标识X轴单位 List<String>的 集合和一个标识折线数据的List<ILineDataSet>组成
    }

    private List<Entry> getChartData1(int count, int ratio) {
        List<Entry> chartData = new ArrayList<>();
        chartData.add( new Entry((float) 24.5491, 0));
        chartData.add(new Entry((float)  23.4535, 1));
        chartData.add(new Entry((float) 24.2589, 2));
        chartData.add(new Entry((float) 23.5745, 3));
        chartData.add(new Entry((float) 22.8808, 4));
//        chartData.add(new Entry((float) 5.0, 5));
//        chartData.add(new Entry((float) 5.0, 6));
//        chartData.add(new Entry((float) 5.0, 7));
//        chartData.add(new Entry((float) 5.0, 8));
//        chartData.add(new Entry((float) 5.0, 9));
//            for (int i = 0; i < count; i++) {
//                chartData.add(new Entry(i * 2 * ratio, i));
//        }
        return chartData;
    }
    private List<Entry> getChartData2(int count, int ratio) {
        List<Entry> chartData = new ArrayList<>();
        chartData.add(new Entry((float) 22.8808, 4));
        chartData.add( new Entry((float) 23.6454, 5));
        chartData.add(new Entry((float) 24.0733, 6));
        chartData.add(new Entry((float) 23.7512, 7));
        chartData.add(new Entry((float)22.5453, 8));
        chartData.add(new Entry((float) 24.9771, 9));
        chartData.add(new Entry((float) 24.1214, 10));
        chartData.add(new Entry((float) 24.4843,11 ));

//        chartData.add(new Entry((float) 55.12, 9));
        return chartData;
    }
    //利用循环生成了(0,0) (2,1) (4,2) (6,3) (8,4)
    //(0,0) (4,1) (8,2) (12,3) (16,4) 这两组折线坐标 组成List<Entry>返回

    private List<String> getLabels(int count) {
        List<String> chartLabels = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            chartLabels.add("18:23:0" + i);
        }
        for (int i = 10; i < 13; i++) {
            chartLabels.add("18:23:" + i);
        }
        return chartLabels; }//生成横坐标的单位显示，(x0 x1 x2 x3 x4)这样的List<String>集合返回

}