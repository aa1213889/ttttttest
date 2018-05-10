package com.example.tttttest.util;

import android.content.Context;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2018/4/10.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }

        private static Toast toast;
        public static void showToast(Context context, String content) {
            if (toast == null) {
                toast = Toast.makeText(context,
                        content,
                        Toast.LENGTH_SHORT);
            } else {
                toast.setText(content);
            }
            toast.show();
        }


}
