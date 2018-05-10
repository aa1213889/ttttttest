package com.example.tttttest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tttttest.CustomView.MyIntentService;
import com.example.tttttest.db.NetWorkActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ConstraintLayout constraintLayout1;
    private PopupMenu mPopupMenu;
    private  MyService.DownloadBinder downloadBinder ;
    private  Button btn_okhttp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mm = (Button)findViewById(R.id.litepal);
        mm.setOnClickListener(this);
        btn_okhttp = (Button)findViewById(R.id.okhttp_btn);
        btn_okhttp.setOnClickListener(this);
        RotateAnimation();
        Button bind_service = (Button)findViewById(R.id.bind_service);
        bind_service.setOnClickListener(this);
        Button unbind_service = (Button)findViewById(R.id.unbind_service);
        unbind_service.setOnClickListener(this);
        Button start_service = (Button)findViewById(R.id.start_service);
        start_service.setOnClickListener(this);
        Button stop_service = (Button)findViewById(R.id.stop_service);
        stop_service.setOnClickListener(this);
        Button start_intent_service = (Button)findViewById(R.id.start_intent_service);
        start_intent_service.setOnClickListener(this);
        Button datebase = (Button)findViewById(R.id.database);
        datebase.setOnClickListener(this);
        Button button = (Button)findViewById(R.id.btn_show_menu);
        final Intent intent =new Intent(this,Main2Activity.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
      Button  button1 = (Button)findViewById(R.id.card);
      button1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1 = new Intent(v.getContext(),CardActivity.class);
              startActivity(intent1);
          }
      });
      Button button2= (Button)findViewById(R.id.login);
      button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1 = new Intent(v.getContext(),LoginActivity.class);
              startActivity(intent1);
          }
      });
      Button button3=(Button)findViewById(R.id.button_news);
      button3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1 = new Intent(getApplicationContext(),NewsActivity.class);
              startActivity(intent1);
          }
      });
      Button button4= (Button)findViewById(R.id.button_custom);
      button4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent1 = new Intent(getApplicationContext(),CustomViewActivity.class);
              startActivity(intent1);
          }
      });
      Button button5 = (Button)findViewById(R.id.button_permission);
      button5.setOnClickListener(this);
constraintLayout1 = (ConstraintLayout)findViewById(R.id.con_layout1);
constraintLayout1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this,"duanan",Toast.LENGTH_SHORT).show();
    }
});
constraintLayout1.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View v) {
        mPopupMenu.show(); //显示布局
        mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override     //重写菜单每一个按钮的点击方法
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.next){
                    Toast.makeText(MainActivity.this,"你点击了下一首",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return false;
    }
});
        mPopupMenu = new PopupMenu(this, constraintLayout1);//参数 1.上下文 ，2.点击的view
        mPopupMenu.inflate(R.menu.main); //绑定菜单布局
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent = new Intent(this,MyService.class);//启动服务
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this,MyService.class);//停止服务
                stopService(stopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this,MyService.class);//绑定服务
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);//解绑服务
                break;
            case R.id.start_intent_service:
                Log.d("MainActivity","Thread id is"+Thread.currentThread().getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
            case R.id.database:
                Intent dataintent = new Intent(this,DatabaseActivity.class);
                startActivity(dataintent);
                break;
            case R.id.litepal:
                Intent liteAintent = new Intent(this,LitepalBookActivity.class);
                startActivity(liteAintent);
                break;
            case R.id.okhttp_btn:
                Intent okhttp_intent = new Intent(this,NetWorkActivity.class);
                startActivity(okhttp_intent);
                break;
            case R.id.button_permission:
                Intent permission_intent = new Intent(this,PermissionActivity.class);
                startActivity(permission_intent);
                overridePendingTransition(R.anim.activity_change_enter,R.anim.activity_change_exit);
                break;
            default:
                break;
        }
    }
    private void RotateAnimation() {
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(btn_okhttp, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(btn_okhttp, "scaleX", 0.0f, 1.0f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(btn_okhttp, "scaleY", 0.0f, 2.0f);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(btn_okhttp, "rotation", 0, 360);
        ObjectAnimator transXAnim = ObjectAnimator.ofFloat(btn_okhttp, "translationX", 100, 400);
      //  ObjectAnimator transYAnim = ObjectAnimator.ofFloat(btn_okhttp, "tranlsationY", 100, 750);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim);
           //    set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
        set.setDuration(3000);
        set.start();

    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}


