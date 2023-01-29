package com.ultralegends.hm9listviewdb;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HelperDB extends SQLiteOpenHelper {

    public HelperDB(@Nullable Context context) {
        super(context, "ListViewDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, task VARCHAR)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(String task)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO tasks (task) values ('"+task+"')";
        db.execSQL(query);
    }

    public ArrayList<String> getTasks()
    {
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT task from tasks";
        Cursor cursor = db.rawQuery(query,null);

        cursor.moveToFirst();   //no need of this by the way(cursor is already on start).
        while(cursor.moveToNext())
        {
            list.add(cursor.getString(0));
        }

        return list;
    }

    public void delete(String str)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM TASKS where task = '"+str+"'";
        db.execSQL(query);
    }

}
