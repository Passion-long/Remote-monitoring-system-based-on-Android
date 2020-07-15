package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private View view;
    private EditText edit1;
    private EditText edit2;
    private TextView txt1;
    private TextView txt2;
    public Button button2;
    String account;
    String passwd;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1=(EditText)findViewById(R.id.account);//账户
        edit2=(EditText)findViewById(R.id.password);//密码

        Button button2 = (Button) findViewById(R.id.LoginBtn);//登录
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account=edit1.getText().toString();//获取文本编辑框的文本内容
                passwd=edit2.getText().toString();
                if(account.equals("abc")&&passwd.equals("123"))//判断密码
                {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"账号或者密码有误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
