package com.example.myapp;
//parameterlists向下跳的scroll view

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDetailsBtnDialog  extends DialogFragment {
    @Bind(R.id.zhuzhaji)
    TextView zhuzhaji;
    @Bind(R.id.pingzhengji)
    TextView pingzhengji;
    @Bind(R.id.wenzhaji)
    TextView wenzhaji;
    private MyListener MyListener;
    private View inflate;

    public void setListener(MyListener listener) {
        this.MyListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(true);
        getDialog().getWindow().setBackgroundDrawableResource(R.color.transparent);
        inflate = inflater.inflate(R.layout.dialog_view_details_btn, container);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.zhuzhaji, R.id.pingzhengji, R.id.wenzhaji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuzhaji:
                MyListener.zhuzhaji();
                dismiss();
                break;
            case R.id.pingzhengji:
                MyListener.pingzhengji();
                dismiss();
                break;
            case R.id.wenzhaji:
                MyListener.wenzhaji();
                dismiss();
                break;
        }
    }
    public interface MyListener {
        void zhuzhaji(); // 铸轧机参数
        void pingzhengji(); // 铸轧机棒图
        void wenzhaji(); // 铸轧机调零
    }

    //全屏宽度操作
    @Override
    public void onStart() {
        super.onStart();
        ViewGroup.LayoutParams lp= inflate.getLayoutParams();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
        lp.width=dm.widthPixels;
        inflate.setLayoutParams(lp);
    }
}
