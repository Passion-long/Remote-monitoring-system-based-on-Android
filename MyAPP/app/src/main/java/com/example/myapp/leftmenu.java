//package com.example.myapp;
//
//import android.app.DialogFragment;
//import android.content.Intent;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.util.DisplayMetrics;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
//public class leftmenu extends DialogFragment implements View.OnClickListener{
//    private View inflate;
//    private TextView deviceintro;
//    private TextView labintro;
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getDialog().setCanceledOnTouchOutside(true);
//        getDialog().getWindow().setBackgroundDrawableResource(R.color.transparent);
//        inflate = inflater.inflate(R.layout.leftmenu, container);
//        ButterKnife.bind(this, inflate);
//        findView(inflate);
//        setListener();
//        return inflate;
//    }
//
//    private void setListener() {
//        deviceintro.setOnClickListener(this);
//        labintro.setOnClickListener(this);
//    }
//
//    private void findView(View a) {
//        deviceintro=a.findViewById(R.id.deviceintro);
//        labintro=a.findViewById(R.id.labintro);
//    }
//
//
//    //全屏宽度操作
//   /* @Override
//    public void onStart() {
//        super.onStart();
//        ViewGroup.LayoutParams lp= inflate.getLayoutParams();
//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
//        lp.width=dm.widthPixels;
//        inflate.setLayoutParams(lp);
//    }*/
//    @Override
//    public void onStart() {
//        super.onStart();
//        Window win = getDialog().getWindow();
//        // 一定要设置Background，如果不设置，window属性设置无效
//        /*  win.setBackgroundDrawable( new ColorDrawable(R.id.TRANSPARENT));*/
//
//        DisplayMetrics dm = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
//
//        WindowManager.LayoutParams params = win.getAttributes();
//        params.gravity = Gravity.TOP;
//        //params.gravity=Gravity.LEFT;
//        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
//        /*params.width =  ViewGroup.LayoutParams.MATCH_PARENT;
//        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;*/
//        win.setAttributes(params);
//    }
//
//    @Override
//    public void onClick(View v) {
//switch (v.getId()){
//    case R.id.deviceintro:
//        Toast.makeText(getActivity(),"设备简介",Toast.LENGTH_SHORT).show();
//        Intent device=new Intent(getActivity(),deviceintro.class);
//        startActivity(device);
//       dismiss();
//        break;
//    case R.id.labintro:
//        Toast.makeText(getActivity(),"实验室简介",Toast.LENGTH_SHORT).show();
//        Intent lab=new Intent(getActivity(), labintro.class);
//        startActivity(lab);
//        dismiss();
//        break;
//}
//    }
//}