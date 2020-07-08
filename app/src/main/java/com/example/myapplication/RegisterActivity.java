<<<<<<< HEAD
package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;//注册按钮
    Button to_login; //返回按钮
    EditText user_name,psw1,psw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    private void init() {
        btn_register=findViewById(R.id.btn_register);
        to_login=findViewById(R.id.to_login);

        user_name=findViewById(R.id.userName);
        psw1=findViewById(R.id.passwd);
        psw2=findViewById(R.id.passwd2);
        //返回按钮
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到登录界面
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //注册按钮
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                        try {
                            String json="{\n" +
                                    "\t\"userName\":\"xhc1\",\n" +
                                    "\t\"password\":\"x123456\",\n" +
                                    "\t\"sex\":\"男\",\n" +
                                    "\t\"age\":1\n" +
                                    "}";
                            OkHttpClient client =new OkHttpClient();
                            Request request=new Request.Builder()
                                    .url("http://192.168.0.111:8086/rest/signup")
                                    .post(RequestBody.create(MediaType.parse("application/json"),json))
                                    .build();
                            Response response =client.newCall(request).execute();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,"网络连接成功！",Toast.LENGTH_SHORT).show();
                                }
                            });

                        }catch (Exception e){
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,"网络连接失败！",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                  }
              }).start();
            }
        });
    }

}
=======
package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {
    Button btn_register;//注册按钮
    Button to_login; //返回按钮
    EditText user_name,psw1,psw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    private void init() {
        btn_register=findViewById(R.id.btn_register);
        to_login=findViewById(R.id.to_login);

        user_name=findViewById(R.id.userName);
        psw1=findViewById(R.id.passwd);
        psw2=findViewById(R.id.passwd2);
        //返回按钮
        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //为了跳转到登录界面
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //注册按钮
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                        try {
                            String json="{\n" +
                                    "\t\"userName\":\"xhc1\",\n" +
                                    "\t\"password\":\"x123456\",\n" +
                                    "\t\"sex\":\"男\",\n" +
                                    "\t\"age\":1\n" +
                                    "}";
                            OkHttpClient client =new OkHttpClient();
                            Request request=new Request.Builder()
                                    .url("http://192.168.0.111:8086/rest/signup")
                                    .post(RequestBody.create(MediaType.parse("application/json"),json))
                                    .build();
                            Response response =client.newCall(request).execute();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,"网络连接成功！",Toast.LENGTH_SHORT).show();
                                }
                            });

                        }catch (Exception e){
                            e.printStackTrace();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,"网络连接失败！",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                  }
              }).start();
            }
        });
    }

}
>>>>>>> 668daeeef2468d955fabf16451e5b72117890641
