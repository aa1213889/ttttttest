package com.example.tttttest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.tttttest.CustomView.CustomView;

public class CustomViewActivity extends AppCompatActivity {
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
         customView = (CustomView)findViewById(R.id.cv1);
        customView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.translate));

    }
}
