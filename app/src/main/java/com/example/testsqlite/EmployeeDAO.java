package com.example.testsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class EmployeeDAO {
  public static boolean save(Employee e, Context context){
    boolean status = false;
    try {
        DatabaseHelper helper = new DatabaseHelper(context);

        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", e.getName());
        values.put("department", e.getDepartment());
        values.put("salary", e.getSalary());
        values.put("age", e.getAge());

        long l = database.insert("employee", null, values);
        database.close();
        if (l != 0) status = true;
    }
    catch (Exception ee){
        Log.e("Error------",""+ee);
        Toast.makeText(context, ""+ee, Toast.LENGTH_SHORT).show();
    }
    return status;
  }
  public static ArrayList<Employee> getEmployeeList(Context context){
      ArrayList<Employee> al = new ArrayList<>();
      SQLiteDatabase database = new DatabaseHelper(context).getReadableDatabase();
      //Cursor c = database.query("employee",null,null,null,null,null,null);
      String sql = "select * from employee";
      Cursor c = database.rawQuery(sql,null);
      while(c.moveToNext()){
         int id = c.getInt(0);
         String name = c.getString(1);
         String department = c.getString(2);
         int salary  = c.getInt(3);
         int age = c.getInt(4);

         Employee e = new Employee(id,name,department,salary,age);
         al.add(e);
      }
      return al;
  }
  public static boolean delete(int id,Context context){
      boolean status = false;
      DatabaseHelper helper = new DatabaseHelper(context);
      SQLiteDatabase db = helper.getWritableDatabase();
      // sql = "delete from employee where id = "+id
      // db.execSql(sql)
      int x = db.delete("employee","id=?",new String[]{""+id});
      if(x!=0)
          status = true;
      return status;
  }
}
