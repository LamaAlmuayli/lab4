package com.example.lab4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String STUDENT_TABLE = "Student_Table";
    public static final String COLUMN_STUDENT_NAME = "STUDENT_NAME";
    public static final String COLUMN_STUDENT_AGE = "STUDENT_AGE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_STUDENT_ACTIVE = "STUDENT_ACTIVE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "student.db", null, 1);
    }

    // when creating the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "Create TABLE " + STUDENT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_STUDENT_NAME + " TEXT, " + COLUMN_STUDENT_AGE + " INT, " + COLUMN_STUDENT_ACTIVE + " BOOLEAN )";
        sqLiteDatabase.execSQL(createTableStatement);

    }
    // when upgrading
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Model studentMod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STUDENT_NAME, studentMod.getName());
        cv.put(COLUMN_STUDENT_AGE, studentMod.getAge());
        cv.put(COLUMN_STUDENT_ACTIVE, studentMod.isActive());
        long insert = db.insert(STUDENT_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

}

