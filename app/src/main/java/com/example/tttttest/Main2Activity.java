package com.example.tttttest;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
 HomeAdapter homeAdapter;
 List<String> numberList=new ArrayList();
 int ischange = 0;
Button buttonis;
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      mRecyclerView=  (RecyclerView)findViewById(R.id.recyclerview);
        buttonis =(Button)findViewById(R.id.buttonis);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//指定RecyclerView为线性布局
        buttonis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ischange==1) {
                    mRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));//指定RecyclerView为线性布局
                    ischange=0;
                }else if(ischange==0){
                    mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
                    mRecyclerView.addItemDecoration(new DividerItemDecoration(Main2Activity.this, 0));
                    //指定为表格布局   spanCount表示一排有几个格子
                    ischange=1;
                }
            }
        });

        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));//设置下划分割线

       mRecyclerView.setItemAnimator(new DefaultItemAnimator()); //设置Item增加和删除时的动画
       init();
        homeAdapter = new HomeAdapter(this,numberList);//
        mRecyclerView.setAdapter(homeAdapter);
    }
    private void init(){
 for(int x=0;x<99;x++){
     numberList.add(""+x);
 }
    }




}
