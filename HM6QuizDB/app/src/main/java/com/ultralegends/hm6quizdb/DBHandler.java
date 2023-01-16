package com.ultralegends.hm6quizdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quizdata.db";
    private static final String TABLE_NAME = "quiz";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SelectOpt = "selected_option";
    private static final String COLUMN_CorrectOpt = "correct_option";
    private static final String COLUMN_IsCorrect = "is_correct";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SelectOpt + " TEXT,"
                + COLUMN_CorrectOpt + " TEXT,"
                + COLUMN_IsCorrect + " INTEGER"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public void insertQuiz(QuizData quiz) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SelectOpt, quiz.getSelectedOption());
        values.put(COLUMN_CorrectOpt, quiz.getCorrectOption());
        values.put(COLUMN_IsCorrect, quiz.getCorrect());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateQuiz(QuizData quiz) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SelectOpt, quiz.getSelectedOption());
        values.put(COLUMN_CorrectOpt, quiz.getCorrectOption());
        values.put(COLUMN_IsCorrect, quiz.getCorrect());

        db.update(TABLE_NAME, values, COLUMN_SelectOpt + " = ?", new String[] {quiz.getSelectedOption()});
        db.close();
    }

    public void deleteQuiz(String selectedOpt) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_SelectOpt + " = ?", new String[] {selectedOpt});
        db.close();
    }


    public List<QuizData> selectAllQuiz() {
        List<QuizData> quiz = new ArrayList<>();

        String sql = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        /*
        * if (cursorCourses.moveToFirst()) {
            do {
                studentArrayList.add(new StudentModel(cursorCourses.getString(1),
                      cursorCourses.getInt(2),
                        cursorCourses.getInt(3) == 1 ? true : false));
            } while (cursorCourses.moveToNext());
        }
        * */

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String selectOpt = cursor.getString(cursor.getColumnIndex(COLUMN_SelectOpt));
                String correctOpt = cursor.getString(cursor.getColumnIndex(COLUMN_CorrectOpt));
                boolean isCorrect = cursor.getInt(cursor.getColumnIndex(COLUMN_IsCorrect))>0;
                quiz.add(new QuizData(selectOpt, correctOpt, isCorrect));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return quiz;
    }


}
