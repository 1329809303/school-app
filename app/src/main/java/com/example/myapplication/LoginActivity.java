package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Dao.article;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.Util.articleAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private List<article> articleList=new ArrayList<>();
    ImageButton to_publish;
    ImageButton taskcontent;
    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        init();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    FormBody.Builder params=new FormBody.Builder();
                    params.add("username","xhc");
                    OkHttpClient client =new OkHttpClient();
                    Request request=new Request.Builder()
                            .url("http://192.168.0.111:8086/rest/GetArticle")
                            .post(params.build())
                            .build();
                    Response response =client.newCall(request).execute();
                    String responseData=response.body().string();
                    JSONArray jsonArray=new JSONArray(responseData);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        article article=new article(jsonObject.getString("username"),jsonObject.getString("title"),jsonObject.getString("time"),jsonObject.getString("content"),R.drawable.image,R.drawable.question,R.drawable.download);
                        articleList.add(article);
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recyclerView=(RecyclerView)findViewById(R.id.recy_list);
                            LinearLayoutManager layoutManager=new LinearLayoutManager(LoginActivity.this);
                            recyclerView.setLayoutManager(layoutManager);
                            articleAdapter adapter=new articleAdapter(articleList,LoginActivity.this);
                            recyclerView.setAdapter(adapter);
                            Toast.makeText(LoginActivity.this,"发布成功！",Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch(Exception e){
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this,"发布失败！",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        }).start();
        recyclerView=(RecyclerView)findViewById(R.id.recy_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(LoginActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        articleAdapter adapter=new articleAdapter(articleList,LoginActivity.this);
        recyclerView.setAdapter(adapter);
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
