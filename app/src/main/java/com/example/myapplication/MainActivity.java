package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button button ;
    TextView textView ;

    int flag = 1; // 一个变
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
    }
    public void btn1_click(View view)
    { // 按一次变一次
        System.out.println(flag);
        if (flag==1) {
            String str_1 = "botton clicked";
            textView.setText(str_1);
            flag = 0; // 别忘了改flag
        } else{
            String str_2 = "activity_main 的 xml";
            textView.setText(str_2);
            flag = 1;
        }
    }
}
