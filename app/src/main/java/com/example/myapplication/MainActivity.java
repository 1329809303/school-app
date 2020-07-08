package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView userName=findViewById(R.id.userName);
        TextView Password=findViewById(R.id.passwd);
        Button btn_register = findViewById(R.id.btn_register);
        Button btn_login=findViewById(R.id.btnLogin);


        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("psw");
        userName.setText(username);
        Password.setText(password);

        //注册控件的点击事件
        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到注册界面，并实现注册功能
                Intent intent=new Intent(MainActivity.this,test.class);
                startActivity(intent);
            }
        });


        //登录的点击事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
