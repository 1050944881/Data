package com.example.data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnrollActivity extends AppCompatActivity  {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    //用户名，密码，再次输入的密码的控件
    private EditText et_user_name,et_psw,et_psw_again;
    //用户名，密码，再次输入的密码的控件的获取值
    private String userName="",psw="",pswAgain="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局 ,注册界面
        setContentView(R.layout.enroll);

        Button btn_register = (Button) findViewById(R.id.btn_register);
        et_user_name = (EditText) findViewById(R.id.et_user);
        et_psw = (EditText) findViewById(R.id.et_password);
        et_psw_again = (EditText) findViewById(R.id.edit_password);
        //注册按钮
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=et_user_name.getText().toString();
                psw=et_psw.getText().toString();
                pswAgain=et_psw_again.getText().toString();
                Cursor cursor = sqLiteDatabase.query("user", new String[]{"name"}, "name=?", new String[]{userName}, null, null, null);
                if(cursor.getCount()!=0) {
                    Toast.makeText(EnrollActivity.this, "该用户已注册!", Toast.LENGTH_SHORT).show();
                }
                if(!psw.equals(pswAgain)){
                    Toast.makeText(EnrollActivity.this,"两次密码输入不一致",Toast.LENGTH_LONG).show();
                }else{
                    dbHelper.addData(sqLiteDatabase, userName, psw, pswAgain);
                    Toast.makeText(EnrollActivity.this, "注册成功,请登录", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(EnrollActivity.this, MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        });

        dbHelper = new DBHelper(EnrollActivity.this, "user_db", null, 1);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }
    public void clickFab(View view) {
        Snackbar.make(view ,"确定要关闭此界面？",Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(EnrollActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        }).show();
    }

}


