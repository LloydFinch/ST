package com.example.lloydfinch.studytest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by LloydFinch on 19/12/2016.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private Context mContext;
    public static String CREATE_DB = "create table Student(id integer primary key autoincrement," +
            "name text,address text)";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
        Toast.makeText(mContext, "create table", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Student");
        onCreate(db);
    }
}
