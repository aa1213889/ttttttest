package com.example.tttttest.CustomView;

import android.os.AsyncTask;

import com.example.tttttest.DownloadListener;

/**
 * Created by Administrator on 2018/3/30.
 */

public class DownloadTask extends AsyncTask<String,Integer,Integer> {

    private  DownloadListener listener;
    public DownloadTask(DownloadListener listener) {
       this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        return null;
    }
}

