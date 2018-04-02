package com.example.tttttest;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class CardActivity extends AppCompatActivity {
    private CardView cardView;
    private SeekBar seekBar1;
    private SeekBar seekBar2;
    private SeekBar seekBar3;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private Button snackbar1;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        assignViews();
    }
    private  void  assignViews(){
        cardView = (CardView)findViewById(R.id.cardView);
        seekBar1=(SeekBar)findViewById(R.id.seekBar);
        seekBar2=(SeekBar)findViewById(R.id.seekBar2);
        seekBar3=(SeekBar)findViewById(R.id.seekBar3);
        textView1=(TextView)findViewById(R.id.textView4);
        textView2=(TextView)findViewById(R.id.textView5);
        textView3=(TextView)findViewById(R.id.textView6);
        constraintLayout=(ConstraintLayout)findViewById(R.id.cons1);
       snackbar1=(Button) findViewById(R.id.snkb);
       snackbar1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               showSnackbar();
           }
       });

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setRadius(progress);//设置圆角大小
                if(progress==0){
                    textView1.setText("控制圆角大小");
                }else {
                    textView1.setText(progress + "%");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setCardElevation(progress); //设置阴影半径
                if(progress==0){
                    textView2.setText("控制阴影大小");
                }else {
                    textView2.setText(progress + "%");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cardView.setContentPadding(progress,progress,progress,progress);//子控件和父控件的距离
//                if(progress==0){
//                    textView3.setText("控制图片间距");
//                }else {
//                    textView3.setText(progress + "%");
//                }
                textView3.setText(progress==0?"控制图片间距":progress + "%");
              //  progress==0?textView3.setText("控制图片间距"):textView3.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void showSnackbar(){

            Snackbar.make(constraintLayout,"标题",Snackbar.LENGTH_LONG).setAction("点击事件", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"点击",Toast.LENGTH_SHORT).show();
                }
            }).show();

    }
}
