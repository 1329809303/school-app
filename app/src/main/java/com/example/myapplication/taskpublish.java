package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class taskpublish extends AppCompatActivity {
    Button publishtask;
    ImageButton to_myhome;
    TextView add_title;
    TextView add_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release);
        init();
        add_title=findViewById(R.id.add_title);
        add_content=findViewById(R.id.add_content);
    }
    private void init()  {
        publishtask=findViewById(R.id.publishtask);
        to_myhome=findViewById(R.id.to_myhome);
        //发布后返回主页
        publishtask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject article=new JSONObject();
                            article.put("username","xhc");
                            article.put("title",add_title.getText().toString());
                            article.put("content",add_content.getText().toString());
                            article.put("UserImage",10003);
                            article.put("time","2020-5-20");
                            article.put("picture",10004);
                            article.put("background","100009");
                            String add_article=article.toString();
                            OkHttpClient client =new OkHttpClient();
                            Request request=new Request.Builder()
                                    .url("http://192.168.0.111:8086/rest/postArticle")
                                    .post(RequestBody.create(MediaType.parse("application/json"),add_article))
                                    .build();
                            Response response =client.newCall(request).execute();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(taskpublish.this,"发布成功！",Toast.LENGTH_SHORT).show();
                                }
                            });

                        }catch (Exception e){
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(taskpublish.this,"发布失败！",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();
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