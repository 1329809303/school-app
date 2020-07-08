package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
public class taskcontent extends AppCompatActivity {
    ImageButton to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_content);
        init();
    }
    private void init() {
        to_home=findViewById(R.id.to_home);
        //返回主页
        to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(taskcontent.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

}