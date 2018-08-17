package com.example.shanliang.mvvmtest;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Utils.DBManager;
import Utils.LocalCupboard;
import model.Book;
import model.Person;
import provider.BookProvider;
import provider.PersonContentProvider;

/**
 * 在此添加 类功能描述
 *
 * @author shanliang
 * @date 2018/8/14
 */
public class SQLiteActivity extends Activity {

    private final String TAG = "SQLiteActivity";

    private DBManager dm;

    private Button btnCreate;
    private Button btnInsert;
    private Button btnClear;
    private Button btnCheck;
    private Button btnShowData;
    private TextView tvCheck;

    private SQLiteDatabase db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_layout);
        init();
    }

    private void init() {
        tvCheck = findViewById(R.id.tv_check);
        btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDataBase();
            }
        });

        btnInsert = findViewById(R.id.btn_insert);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

        btnClear = findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearData();
            }
        });

        btnCheck= findViewById(R.id.btn_check);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnShowData= findViewById(R.id.btn_show_list);
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });

        dm = new DBManager(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dm.closeDB();
    }

    private void createDataBase() {
        create();
    }


    private void insertData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bookName", "图书喜+1");
        getContentResolver().insert(BookProvider.BOOK_URI, contentValues);
    }


    private void clearData() {
        getContentResolver().delete(BookProvider.BOOK_URI, null, null);
    }

    private void create() {
        //ContentValues values = LocalCupboard.getInstance().withEntity(Person.class).toContentValues(person);
        //getContentResolver().insert(PersonContentProvider.PERSON_URI, values);
        Uri bookUri = BookProvider.BOOK_URI;
        ContentValues values = new ContentValues();
        values.put("bookName","威震天");
        getContentResolver().insert(bookUri, values);
        Book book = new Book();
        book.setBookName("擎天柱");
        ContentValues contentValues = LocalCupboard.getInstance().withEntity(Book.class).toContentValues(book);
        getContentResolver().insert(bookUri, contentValues);
        Cursor bookCursor = getContentResolver().query(bookUri, new String[]{"_id", "bookName"}, null, null, null);
        if (bookCursor != null) {
            while (bookCursor.moveToNext()) {
                Log.e(TAG, "ID:" + bookCursor.getInt(bookCursor.getColumnIndex("_id"))
                        + "  BookName:" + bookCursor.getString(bookCursor.getColumnIndex("bookName")));
            }
            bookCursor.close();
        }

    };

    private void showData() {
        Intent intent = new Intent(this, ShowSQLiteDataActivity.class);
        startActivity(intent);
    }




}
