package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class taskpublish extends AppCompatActivity {
    Button publishtask;
    ImageButton to_myhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release);
        init();
    }
    private void init() {
        publishtask=findViewById(R.id.publishtask);
        to_myhome=findViewById(R.id.to_myhome);
        //返回主页
        publishtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(taskpublish.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        //回到个人主页
        to_myhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(taskpublish.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}