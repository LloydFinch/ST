package com.example.lloydfinch.studytest;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button;

    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) this.findViewById(R.id.button_click);
        button.setOnClickListener((v) -> {
            this.test();
            Toast.makeText(this, "this is lambda expression", Toast.LENGTH_LONG).show();
        });
    }

    private void test() {
        testSqLite();
        testInsert();
        testQuery();
        testUpdate();
        testDelete();
    }

    private void testLoader() {

    }

    private void testSqLite() {
        MySQLiteOpenHelper openHelper = new MySQLiteOpenHelper(this, "students.db", null, 3);
        mDB = openHelper.getWritableDatabase();
    }

    private void testInsert() {
        ContentValues values = new ContentValues();
        values.put("name", "finch");
        values.put("address", "beijing");
        mDB.insert("Student", null, values);

        values.clear();
        values.put("name", "lloyd");
        values.put("address", "shanghai");
        mDB.insert("Student", null, values);
        //mDB.close();
    }

    private void testUpdate() {

        ContentValues values = new ContentValues();
        values.put("address", "wuhan");
        mDB.update("Student", values, "name = ?", new String[]{"finch"});
        //mDB.close();
    }

    private void testDelete() {
        mDB.delete("Student", "name = ?", new String[]{"lloyd"});
    }

    private void testQuery() {
        Cursor cursor = mDB.query("Student", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                Log.d("SQL", "id:" + id + ", name:" + name + ", address:" + address);
            } while (cursor.moveToNext());
        }
        cursor.close();
        cursor = null;
        //mDB.close();
    }
}
