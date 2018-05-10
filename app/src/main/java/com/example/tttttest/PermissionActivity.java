package com.example.tttttest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tttttest.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

public class PermissionActivity extends AppCompatActivity {
       List<String> contactsList = new ArrayList<>();
       ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        init();
    }
    private void init(){
        ListView contactView = (ListView)findViewById(R.id.contact_list);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,contactsList);
        contactView.setAdapter(arrayAdapter);
        if(ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(PermissionActivity.this,new String[]{Manifest.permission.READ_CONTACTS},2);
        }else {
            readContact();
        }
        Button button = (Button)findViewById(R.id.button_call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(PermissionActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(PermissionActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
                }
                else {
                    call();
                }

            }
        });
    }
    private void call(){
        try {
            Intent call_intent = new Intent(Intent.ACTION_CALL);
            call_intent.setData(Uri.parse("tel:10086"));
            startActivity(call_intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }
    private void readContact(){
        Cursor cursor = null;
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        if(cursor != null){
            while (cursor.moveToNext()){
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contactsList.add(displayName+"\n"+number);
            }
            arrayAdapter.notifyDataSetChanged();
        }
        cursor.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                   call();
                }else {
                    HttpUtil.showToast(getApplicationContext(),"你没有授予拨打电话权限！");
                }
                break;
            case 2:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                   readContact();
                }else {
                    HttpUtil.showToast(getApplicationContext(),"你没有授予读取联系人权限！");
                }
                break;
                default:
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_change_enter,R.anim.activity_change_exit);
    }
}
