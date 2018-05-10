package com.example.tttttest.util;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tttttest.R;

public class BabyCardActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_phoneID,tv_sex,tv_grade,tv_height,tv_birthday,tv_weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_card);
        initView();
    }
    private void initView(){

        findViewById(R.id.bc_rl_phoneID).setOnClickListener(this);
        findViewById(R.id.bc_rl_sex).setOnClickListener(this);
        findViewById(R.id.bc_rl_grade).setOnClickListener(this);
        findViewById(R.id.bc_rl_height).setOnClickListener(this);
        findViewById(R.id.bc_rl_birthday).setOnClickListener(this);
        findViewById(R.id.bc_rl_weight).setOnClickListener(this);
        tv_phoneID = (TextView)findViewById(R.id.bc_tx_phoneID);
        tv_sex = (TextView)findViewById(R.id.bc_tx_sex);
        tv_grade = (TextView)findViewById(R.id.bc_tx_grade);
        tv_height = (TextView)findViewById(R.id.bc_tx_height);
        tv_birthday = (TextView)findViewById(R.id.bc_tx_birthday);
        tv_weight = (TextView)findViewById(R.id.bc_tx_weight);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bc_rl_phoneID:
               showPhoneIDDialog();
                break;
            case R.id.bc_rl_sex:
                Toast.makeText(BabyCardActivity.this,"mmm!2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bc_rl_grade:
                Toast.makeText(BabyCardActivity.this,"mmm!3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bc_rl_height:
                Toast.makeText(BabyCardActivity.this,"mmm!4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.bc_rl_birthday:

                break;
            case R.id.bc_rl_weight:
                Toast.makeText(BabyCardActivity.this,"mmm!6",Toast.LENGTH_SHORT).show();
                break;


        }
    }
    private void showPhoneIDDialog(){

    }
}
