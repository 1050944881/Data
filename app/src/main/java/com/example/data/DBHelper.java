package com.example.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper( Context context, String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
// TODO Auto-generated method stub
        //创建数据表
        String sql = "create table user(id integer primary key autoincrement,name varchar(20),password varchar(20),agin varchar(20))";
       sqLiteDatabase.execSQL(sql);

    }
    //将注册信息添加到数据表user中
    public void addData(SQLiteDatabase sqLiteDatabase,String name,String password,String agin){
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("password", password);
        values.put("agin", agin);
        sqLiteDatabase.insert("user", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
