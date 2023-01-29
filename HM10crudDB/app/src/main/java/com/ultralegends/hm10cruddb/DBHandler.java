package com.ultralegends.hm10cruddb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final String TABLE_NAME = "students";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ROLLNO = "roll_no";
    private static final String COLUMN_ENROLL = "is_enroll";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_ROLLNO + " TEXT,"
                + COLUMN_ENROLL + " INTEGER"
                + ")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public void insert(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,student.getName());
        values.put(COLUMN_NAME,student.getName());
        values.put(COLUMN_NAME,student.getName());

        db.insert(TABLE_NAME,null,values);

        db.close();
    }

    public void update(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,student.getName());
        values.put(COLUMN_ROLLNO,student.getName());
        values.put(COLUMN_ENROLL,student.getName());

        db.update(TABLE_NAME,values,COLUMN_ROLLNO+" = ?",new String[]{student.getRollNo()});

        db.close();
    }

    public void delete(String rollNo)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME,COLUMN_ROLLNO+" = ?",new String[]{rollNo});

        db.close();
    }

    public ArrayList<Student> getStudents()
    {
        ArrayList<Student> list = new ArrayList<Student>();

        String query = "SELECT * FROM "+TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            while (cursor.moveToNext())
            {
                list.add(new Student(cursor.getString(1),cursor.getString(2),cursor.getInt(3)==1?true:false));
            }
        }

        cursor.close();
        db.close();

        return list;
    }

}
