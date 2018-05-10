package com.example.tttttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tttttest.db.Note;

import org.litepal.crud.DataSupport;

import java.util.List;

public class LitepalBookActivity extends AppCompatActivity {
 private   Button data_b ;
  private  TextView tv_title,tv_content ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepal_book);
        data_b = (Button)findViewById(R.id.intent_book);
        tv_title = (TextView)findViewById(R.id.lp_title);
        tv_content = (TextView)findViewById(R.id.lp_content);
        data_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LitepalBookActivity.this,TextEditActivity.class);
                startActivity(intent);
            }
        });
        List<Note> notes = DataSupport.findAll(Note.class);
        for(Note note:notes){
            tv_title.setText(note.getTitle());
            tv_content.setText(note.getContent());
        }

    }
}
