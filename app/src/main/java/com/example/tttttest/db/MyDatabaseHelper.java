package com.example.tttttest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/3.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private  Context mContext;
    public  static final String CREATE_BOOK = "create table Book("
                                            +"id integer primary key autoincrement,"
                                            +"author text,"
                                            +"price real,"
                                            +"pages integer,"
                                            +"name text)";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);//建表语句定义成一个字符常量，在此方法中进行建表
        Toast.makeText(mContext,"Create Succeeded！",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Toast.makeText(mContext,"onUpgrade Succeeded！",Toast.LENGTH_SHORT).show();
    }
}
