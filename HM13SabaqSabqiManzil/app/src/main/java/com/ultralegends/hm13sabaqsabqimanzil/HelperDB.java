package com.ultralegends.hm13sabaqsabqimanzil;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HelperDB extends SQLiteOpenHelper {
    public HelperDB(@Nullable Context context) {
        super(context,"StudentSabaqDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE students (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR , rollno VARCHAR, sabaq int, sabqi int, manzil int)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(Students std)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO students (name, rollno, sabaq, sabqi, manzil) values ('"+std.getName()+"','"+std.getRollNo()+"',"+std.getSabaq()+","+std.getSabqi()+","+std.getManzil()+")";
        db.execSQL(query);
    }

    public ArrayList<Students> getStudents()
    {
        ArrayList<Students> list = new ArrayList<Students>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT id, name, rollno, sabaq, sabqi, manzil from students";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())  //By the way no need of this.(cursor is already on start).
        {
            while (cursor.moveToNext()) {
                list.add(new Students(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5)));
            }
        }
        return list;
    }

    public void delete(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM students where id = "+id+"";
        db.execSQL(query);
    }
}
