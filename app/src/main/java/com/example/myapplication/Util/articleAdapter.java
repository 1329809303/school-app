package com.example.myapplication.Util;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Dao.article;
import com.example.myapplication.R;
import com.example.myapplication.taskcontent;

import java.util.List;

public class articleAdapter extends RecyclerView.Adapter<articleAdapter.MyHolder> {
    public Context con;
    List<article> articles;
    public articleAdapter(List<article> articles,Context con){
        this.articles=articles;
        this.con=con;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent,int viewType) {
      View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.article,parent,false);
      MyHolder holder=new MyHolder(view);
      holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(con, taskcontent.class);
                con.startActivity(intent);
            }
        });
      return holder;
    }
    @Override
    public void  onBindViewHolder(MyHolder holder,int postion){
        article article=articles.get(postion);
        holder.content.setText(article.getContent());
        holder.picture.setImageResource(article.getPicture());
        holder.title.setText(article.getTitle());
        holder.UserImage.setImageResource(article.getUserImage());
        holder.username.setText(article.getUsername());
        holder.background.setImageResource(article.getBackground());
    }
    @Override
    public int getItemCount(){
        return articles.size();
    }
    class MyHolder extends RecyclerView.ViewHolder  {
        ImageView UserImage;
        ImageView picture;
        TextView title;
        TextView username;
        TextView content;
        ImageButton background;
        public MyHolder(View itemView){
            super(itemView);
            content=(TextView)itemView.findViewById(R.id.article_content);
            picture=(ImageView)itemView.findViewById(R.id.article_picture);
            title=(TextView)itemView.findViewById(R.id.add_title);
            UserImage=(ImageView)itemView.findViewById(R.id.article_UserImage);
            username=(TextView)itemView.findViewById(R.id.article_username);
            background=(ImageButton)itemView.findViewById(R.id.article_backgroud);
        }
    }
}
