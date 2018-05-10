package com.example.tttttest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tttttest.db.MyDatabaseHelper;

public class DatabaseActivity extends AppCompatActivity {
    private MyDatabaseHelper myDatabaseHelper;
    private EditText edit_name, edit_price, edit_pages, edit_author;
    private Button add_data, query_data;
    private TextView oput_name, oput_price, oput_pages, oput_author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        myDatabaseHelper = new MyDatabaseHelper(getApplicationContext(), "BookStore.db", null, 1);
        Button create_db = (Button) findViewById(R.id.create_database);
        create_db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();
            }
        });
        initView();
        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();

            }
        });
        query_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryData();
            }
        });

    }

    public void queryData() {
      //  myThreadMiao();
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
      final   StringBuffer sb = new StringBuffer();
        if (cursor.moveToFirst()) {
            do {
                sb.append("name=").append(cursor.getString(cursor.getColumnIndex("name"))).append(" ")
                        .append("author=").append(cursor.getString(cursor.getColumnIndex("author"))).append(" ")
                        .append("pages=").append(cursor.getString(cursor.getColumnIndex("pages"))).append(" ")
                        .append("price=").append(cursor.getString(cursor.getColumnIndex("price"))).append(" ")
                        .append("\n");
            } while (cursor.moveToNext());
        }
        cursor.close();
        Log.d("Database","主线程里的"+Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("Database","Thread里的"+Thread.currentThread().getName());
            }
        }).start();
         runOnUiThread(new Runnable() {
             @Override
             public void run() {
                 oput_price.setText("查询结果是：\n" + sb.toString());
                 Log.d("Database","runOnUiThread里的"+Thread.currentThread().getName());
             }
         });

    }

    public void addData() {
        SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", edit_name.getText().toString());
        values.put("author", edit_author.getText().toString());
        values.put("pages", edit_pages.getText().toString());
        values.put("price", edit_price.getText().toString());
        db.insert("Book", null, values);
        values.clear();
        Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
    }

    public void initView() {
        edit_author = (EditText) findViewById(R.id.input_book_author);
        edit_name = (EditText) findViewById(R.id.input_bookname);
        edit_pages = (EditText) findViewById(R.id.input_book_page);
        edit_price = (EditText) findViewById(R.id.input_book_price);
        add_data = (Button) findViewById(R.id.add_data_database);
        query_data = (Button) findViewById(R.id.query_data);
        oput_author = (TextView) findViewById(R.id.output_book_author);
        oput_name = (TextView) findViewById(R.id.output_book_name);
        oput_pages = (TextView) findViewById(R.id.output_book_pages);
        oput_price = (TextView) findViewById(R.id.output_book_price);
    }


}

