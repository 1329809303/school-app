package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import com.example.myapplication.HomeFragment;

//FragmentTabHost使用第一步，继承FragmentActivity
// AppCompatActivity已经默认继承FragmentActivity，不用再继承FragmentActivity
public class test extends AppCompatActivity {

    //读取View时用到LayoutInflater
    private LayoutInflater mInflater;

    private FragmentTabHost mTabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weibo);

        mInflater = LayoutInflater.from(this);

        //找到mTabhost
        mTabhost = this.findViewById(android.R.id.tabhost);

        //第二步，重写setup方法
        //第三个参数是用来装载FragmentTabHost的容器的id
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

        //第三步，添加TabSpec
        TabHost.TabSpec tabSpec = mTabhost.newTabSpec("home");


        View view = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView)view.findViewById(R.id.icon_tab);
        TextView text = (TextView)view.findViewById(R.id.txt_indicator);

        //添加自己的背景图片
        img.setBackgroundResource(R.drawable.icon_home);
        //添加背景图片下方的文字
        text.setText("主页");

        //第四步，往Indicator添加View
        tabSpec.setIndicator(view);

        //最后一步，将tabSpec添加到mTabhost
        mTabhost.addTab(tabSpec,HomeFragment.class,null);

    }
}

