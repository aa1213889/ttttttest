package com.example.tttttest.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tttttest.R;
import com.example.tttttest.util.HttpUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetWorkActivity extends AppCompatActivity {
   TextView responseText;
   EditText editText;
   Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        responseText = (TextView)findViewById(R.id.response_tv);
        editText = (EditText)findViewById(R.id.url_tv);
        button = (Button)findViewById(R.id.url_button);
        Log.d("NetWork","onCreate Thread id is"+Thread.currentThread().getId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtil.sendOkHttpRequest("http://" + editText.getText().toString(), new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                       showResponse(response.body().string());
                    }
                });
            }
        });
    }
    private void  showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
                Log.d("NetWork","showResponse Thread id is"+Thread.currentThread().getId());
            }
        });
    }

}
