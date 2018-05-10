package com.example.tttttest.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2018/4/8.
 */

public class Note extends DataSupport {
    private String title,content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
