package com.example.tttttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tttttest.db.Note;

import org.litepal.LitePal;

public class TextEditActivity extends AppCompatActivity {
private Button save_btn ;
private EditText edit_title_1,edit_content_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edit);
        LitePal.getDatabase();
        edit_title_1 = (EditText) findViewById(R.id.edit_title_tea);
        edit_content_1 = (EditText)findViewById(R.id.edit_content_tea);
        save_btn = (Button)findViewById(R.id.save_note_tea);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
                finish();
            }
        });
    }
   public void addData(){
       Note note = new Note();
       note.setTitle(edit_title_1.getText().toString());
       note.setContent(edit_content_1.getText().toString());
       note.save();
   }
}
