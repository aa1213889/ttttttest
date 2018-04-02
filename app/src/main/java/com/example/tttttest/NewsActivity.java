package com.example.tttttest;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {
private ViewPager mViewPager;
private TableLayout mTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        mViewPager=(ViewPager)findViewById(R.id.viewpages);
        mTableLayout = (TableLayout)findViewById(R.id.tabs);
       initViewPager();
    }
    private void  initViewPager(){


        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("手机");
        titles.add("科技");
        titles.add("文章");
        titles.add("体育");
        titles.add("经济");
        titles.add("动漫");
        titles.add("历史");
//        for(int i= 0;i<titles.size();i++){
//            mTableLayout.addTab(mTableLayout.newTab().setText(titles.get(i)));
//        }
    }
}
