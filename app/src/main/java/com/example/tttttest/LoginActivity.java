package com.example.tttttest;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
private EditText username;
private EditText password;
private Button login_button;
private static  final  String EAMIL_PATTERN="^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$" ; //邮箱的正则表达式
private Pattern pattern;  //正则模式
private Matcher matcher;  //正则比较
private TextInputLayout tl_user;
    private TextInputLayout tl_pswd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        tl_user=(TextInputLayout)findViewById(R.id.tl_user);
        tl_pswd=(TextInputLayout)findViewById(R.id.tl_pswd);
        login_button = (Button)findViewById(R.id.button_login);

       login_button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               init();
           }
       });
    }
    public  void init(){
        String un = tl_user.getEditText().getText().toString();
        String pw = tl_pswd.getEditText().getText().toString();
        pattern = Pattern.compile(EAMIL_PATTERN);
        if(!validateUsername(un)){
            tl_user.setErrorEnabled(true);
            tl_user.setError("请输入正确的邮箱地址");
        }else if(!validatePassword(pw)){
           tl_pswd.setEnabled(true);
            tl_pswd.setError("密码长度不足");
        }else{
            tl_user.setErrorEnabled(false);
            tl_pswd.setErrorEnabled(false);
          //  Toast.makeText(LoginActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
            Snackbar.make(login_button,"登陆成功！",Snackbar.LENGTH_SHORT).show();
        }
    }
    private boolean validatePassword(String password){
        return password.length()>6; //密码长度要超过6位数
    }
    private boolean validateUsername(String username){
        matcher = pattern.matcher(username); //正则匹配
        return  matcher.matches();
    }
}
