package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Dao.article;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.Util.articleAdapter;
public class LoginActivity extends AppCompatActivity {
    private List<article> articleList=new ArrayList<>();
    ImageButton to_publish;
    ImageButton taskcontent;
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        init();
        initArticle(articleList);
        recyclerView=(RecyclerView)findViewById(R.id.recy_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        articleAdapter adapter=new articleAdapter(articleList,this);
        recyclerView.setAdapter(adapter);
    }
    private void initArticle(List<article> articles){
        article a1 = new article("发帖人:李华", "求解一道数分题", "05-20", "求求各位大佬帮忙解决一下问题", R.drawable.image, R.drawable.question,R.drawable.download);
        article a2 = new article("发帖人:李华", "求解一道数分题", "05-20", "求求各位大佬帮忙解决一下问题", R.drawable.image, R.drawable.question,R.drawable.download);
        article a3 = new article("发帖人:李华", "求解一道数分题", "05-20", "求求各位大佬帮忙解决一下问题", R.drawable.image, R.drawable.question,R.drawable.download);
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
    }
    private void init() {
       to_publish=findViewById(R.id.to_publish);
       taskcontent=findViewById(R.id.article_backgroud);
        //查看详情按钮

        //发布任务按钮
       to_publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,taskpublish.class);
                startActivity(intent);
            }
        });
    }
}
