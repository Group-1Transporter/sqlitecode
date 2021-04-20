package com.example.testsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context){
        super(context,"userdb.sqlite",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
      String sql = "create table employee(id integer primary key AUTOINCREMENT,name varchar(100)," +
              "department varchar(100), salary integer(11), age integer(3))";
      db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
